package dao.impl;



import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Base64;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import dao.OcexPreinscripcionDAO;
import entity.OcexArmRev;
import entity.OcexAutorFranc;
import entity.OcexFicMed;
import entity.OcexPapVac;
import entity.OcexPerPnp;
import entity.OcexPreInsc;
import logica.LogicaUsuario;
public class OcexPreinscripcionDAOImpl implements OcexPreinscripcionDAO {

	@Override
	public boolean SP_RegistrarPreinscripcion(String tipo, String fechainivac, String txtdiasvac, String fechafinvac,
			String fechainiservicio, String txtdiasservicio, String fechafinservicio, String diasfranco,
			String messervicio, String añoservicio, String id_fichero1, String aptitud, String nrofichamedica,
			String pistola, String serie, String marca, String calibre, String caf, String municion, String nrorevista,
			String unidadrevista, String cuenta, String telefono, String domicilio,int idPersona,
			String id_fichero0, String id_fichero2, String id_fichero3,String usuario) {
		int idfichero1=0;
		if (id_fichero1.length()>0) {
			 idfichero1=Integer.parseInt(id_fichero1);
		}
		int idfichero0=0;
		if (id_fichero0.length()>0) {
			idfichero0=Integer.parseInt(id_fichero0);
		}
		int idfichero2=0;
		if (id_fichero2.length()>0) {
			idfichero2=Integer.parseInt(id_fichero2);
		}
		int idfichero3=0;
		if (id_fichero3.length()>0) {
			idfichero3=Integer.parseInt(id_fichero3);
		}
		
		if (tipo.equals("FRANCO")) {
			fechainivac=null;
			fechafinvac=null;
			fechainiservicio=null;
			fechafinservicio=null;
		} 
		String dato = null;
		boolean rpta=false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				 CallableStatement cs = null;
				 cs = cn.prepareCall("call PRE_INSC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				 cs.setString(1,usuario);
				 cs.setInt(2,idPersona);
				 cs.setInt(3,idfichero1);
				 cs.setString(4,diasfranco);
				 cs.setString(5,messervicio);
				 cs.setString(6,añoservicio);
				 cs.setString(7,txtdiasvac);
				 cs.setString(8,fechainivac);
				 cs.setString(9,fechafinvac);
				 cs.setInt(10,idfichero0);
				 cs.setString(11,fechainiservicio);
				 cs.setString(12,fechafinservicio);
				 cs.setString(13,aptitud);
				 cs.setString(14,nrofichamedica);
				 cs.setInt(15,idfichero2);
				 cs.setString(16,nrorevista);
				 cs.setString(17,marca);
				 cs.setString(18,calibre);
				 cs.setString(19,pistola);
				 cs.setString(20,serie);
				 cs.setString(21,"DOS (02) CACERINAS");
				 cs.setString(22,caf);
				 cs.setString(23,municion);
				 cs.setInt(24,idfichero3);
				 cs.setString(25,unidadrevista);
				 cs.setString(26,tipo);
				 cs.setString(27,txtdiasservicio);
				 cs.registerOutParameter(28,Types.VARCHAR);
				 cs.execute();	
				 dato = cs.getString(28);
			} catch (SQLException e) {
				System.out.println("Excepcion en call PRE_INSC(?,?,....: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		if (dato!=null) {
			if (dato.equals("OK")) {
				rpta=true;
			}else if (dato.equals("NOK")) {
				rpta=false;
			}
		}else {
			rpta=false;
		}
		System.out.println(" rpta OUT PARAMETER : " + dato);
		return rpta;	
	}

	@Override
	public int consultainscripcionok(int id_per) {
		int  id_persona = 0;
		String query = "SELECT ID_PRE FROM OCEX_PRE_INSC  where ID_PER=? and   TO_CHAR(FECHA_REG, 'MM-YYYY')=TO_CHAR(SYSDATE, 'MM-YYYY')";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setInt(1, id_per);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					id_persona=rs.getInt("ID_PRE");
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query consultainscripcionok: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return id_persona;
	}

	@Override
	public String consultapreinscripcionxCip(String Cip) throws IOException {
		String  respuesta = null;
		byte[] blobarma = null;
		byte[] blobvacaciones = null;
		byte[] blobfranco= null;
		byte[] blobmedico = null;
	    JsonArray array = null;
	    String json = "";
	    OcexPerPnp persona= null;
		OcexPreInsc preinscripcion= null;
		OcexArmRev arma = null;
		OcexFicMed medico= null;
		OcexPapVac vacaciones= null;
		OcexAutorFranc franco= null;
		String query = "SELECT PRE.ID_PRE,\r\n" + 
				"  PRE.MOD_PRE,\r\n" + 
				"  PRE.F_MES,\r\n" + 
				"  PRE.V_INI_CUS,\r\n" + 
				"  PRE.V_FIN_CUS,\r\n" + 
				"  PRE.ID_PER,\r\n" + 
				"  PRE.F_ANIO,\r\n" + 
				"  PRE.F_DIAS_FRANCO,\r\n" + 
				"  PRE.V_CANT_CUS,\r\n" + 
				"  PERSONA.ID_PER,\r\n" + 
				"  PERSONA.NOM_PER,\r\n" + 
				"  PERSONA.APE_PAT_PER,\r\n" + 
				" PERSONA.APE_MAT_PER,\r\n" + 
				" PERSONA.GRADO_PER,\r\n" + 
				"  PERSONA.DOM_PER,\r\n" + 
				"  PERSONA.NOM_UNI_PER,\r\n" + 
				"  PERSONA.FEC_NAC,\r\n" + 
				"  PERSONA.GEN_PER,\r\n" + 
				"  PERSONA.DNI_PER,\r\n" + 
				"  PERSONA.TEL_CEL_PER,\r\n" + 
				"  PERSONA.CTA_AHOR_PER,\r\n" + 
				"  PERSONA.CIP_PER,\r\n" + 
				"  PERSONA.CORREO_PNP,\r\n" + 
				"  ARMA.ID_PAP_ARM,\r\n" + 
				"  ARMA.NRO_REV_ARM,\r\n" + 
				"  ARMA.MARC_ARM,\r\n" + 
				"  ARMA.CAL_ARM,\r\n" + 
				"  ARMA.CLAS_ARM,\r\n" + 
				"  ARMA.NRO_SER_ARM,\r\n" + 
				"  ARMA.ACCES_ARM,\r\n" + 
				"  ARMA.CAF_ARM,\r\n" + 
				"  ARMA.CANT_MUN,\r\n" + 
				"  ARMA.UNID_EMITE,\r\n" + 
				"  FI_ARMA.IMAGE_FICHER as blobarma,\r\n" + 
				"  MEDICO.ID_FIC_MED,\r\n" + 
				"  MEDICO.APT_PNP,\r\n" + 
				"  MEDICO.NRO_FIC_MED,\r\n" + 
				"  FI_MEDICO.IMAGE_FICHER as blobmedico,\r\n" + 
				"  VACACIONES.ID_P_VAC,\r\n" + 
				"  VACACIONES.CANT_VAC,\r\n" + 
				"  VACACIONES.INI_VAC,\r\n" + 
				"  VACACIONES.FIN_VAC,\r\n" + 
				"  FI_VACACIONES.IMAGE_FICHER as blobvacaciones,\r\n" + 
				"  FRANCO.ID_AUT,\r\n" + 
				"  FRANCO.DIAS_FRANCO,\r\n" + 
				"  FRANCO.MES,\r\n" + 
				"  FRANCO.ANIO,\r\n" + 
				"  FI_FRANCO.IMAGE_FICHER as blobfranco\r\n" + 
				"FROM OCEX_PRE_INSC PRE \r\n" + 
				"INNER JOIN OCEX_PER_PNP PERSONA ON PERSONA.ID_PER=PRE.ID_PER\r\n" + 
				"JOIN OCEX_ARM_REV  ARMA ON ARMA.ID_PAP_ARM=(SELECT MAX(ID_PAP_ARM) FROM  OCEX_ARM_REV where USU_REG=?) \r\n" + 
				"JOIN OCEX_FICHER FI_ARMA ON FI_ARMA.ID_FICHER=ARMA.ID_FICHER\r\n" + 
				"JOIN OCEX_FIC_MED MEDICO ON  MEDICO.ID_FIC_MED=(SELECT MAX(ID_FIC_MED) FROM  OCEX_FIC_MED where USU_REG=?) \r\n" + 
				"JOIN OCEX_FICHER FI_MEDICO ON FI_MEDICO.ID_FICHER=MEDICO.ID_FICHER\r\n" + 
				"LEFT JOIN OCEX_PAP_VAC  VACACIONES ON VACACIONES.ID_P_VAC=(SELECT MAX(ID_P_VAC) FROM  OCEX_PAP_VAC where USU_REG=?) AND PRE.MOD_PRE='VACACIONES' \r\n" + 
				"LEFT JOIN OCEX_FICHER FI_VACACIONES ON FI_VACACIONES.ID_FICHER=VACACIONES.ID_FICHER\r\n" + 
				"LEFT JOIN OCEX_AUTOR_FRANC  FRANCO ON FRANCO.ID_AUT=(SELECT MAX(ID_AUT) FROM  OCEX_AUTOR_FRANC where USU_REG=?)  AND PRE.MOD_PRE='FRANCO' \r\n" + 
				"LEFT JOIN OCEX_FICHER FI_FRANCO ON FI_FRANCO.ID_FICHER=FRANCO.ID_FICHER\r\n" + 
				"where  TO_CHAR(PRE.FECHA_REG, 'MM-YYYY')=TO_CHAR(SYSDATE, 'MM-YYYY') and PRE.usu_reg=? and PRE.FLAG_PRE='1' ";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1, Cip);
				ps.setString(2, Cip);
				ps.setString(3, Cip);
				ps.setString(4, Cip);
				ps.setString(5, Cip);
				ResultSet rs = ps.executeQuery();
				
				array = new JsonArray();
				if (rs.next()) {
					 persona=new OcexPerPnp(); 
					 preinscripcion=new OcexPreInsc();
					 arma =new OcexArmRev();
					 medico = new OcexFicMed();
					 vacaciones= new OcexPapVac();
					 franco=new OcexAutorFranc();
					persona.setIdPer(rs.getInt("ID_PER"));
					persona.setNomPer(rs.getString("NOM_PER"));
					persona.setApePatPer(rs.getString("APE_PAT_PER"));
					persona.setApeMatPer(rs.getString("APE_MAT_PER"));
					persona.setGradoPer(rs.getString("GRADO_PER"));
					persona.setDomPer(rs.getString("DOM_PER"));
					persona.setNomUniPer(rs.getString("NOM_UNI_PER"));
					persona.setFecNac(rs.getString("FEC_NAC"));
					persona.setGenPer(rs.getString("GEN_PER"));
					persona.setDniPer(rs.getString("DNI_PER"));
					persona.setTelCelPer(rs.getString("TEL_CEL_PER"));
					persona.setApePatPer(rs.getString("APE_PAT_PER"));
					persona.setCtaAhorPer(rs.getString("CTA_AHOR_PER"));
					persona.setCipPer(rs.getString("CIP_PER"));
					persona.setCorreoPnp(rs.getString("CORREO_PNP"));
					preinscripcion.setIdPre(rs.getInt("ID_PRE"));
					preinscripcion.setModPre(rs.getString("MOD_PRE"));
					preinscripcion.setFMes(rs.getString("F_MES"));
					preinscripcion.setVIniCus(rs.getDate("V_INI_CUS"));
					preinscripcion.setVFinCus(rs.getDate("V_FIN_CUS"));
					preinscripcion.setIdPer(rs.getInt("ID_PER"));
					preinscripcion.setFAnio(rs.getString("F_ANIO"));
					preinscripcion.setFDiasFranco(rs.getString("F_DIAS_FRANCO"));
					preinscripcion.setVCantCus(rs.getString("V_CANT_CUS"));
					arma.setIdPapArm(rs.getInt("ID_PAP_ARM"));
					arma.setNroRevArm(rs.getString("NRO_REV_ARM"));
					arma.setMarcArm(rs.getString("MARC_ARM"));
					arma.setCalArm(rs.getString("CAL_ARM"));
					arma.setClasArm(rs.getString("CLAS_ARM"));
					arma.setNroSerArm(rs.getString("NRO_SER_ARM"));
					arma.setAccesArm(rs.getString("ACCES_ARM"));
					arma.setCafArm(rs.getString("CAF_ARM"));
					arma.setCantMun(rs.getString("CANT_MUN"));
					arma.setUnidEmite(rs.getString("UNID_EMITE"));
					medico.setIdFicMed(rs.getInt("ID_FIC_MED"));
					medico.setAptPnp(rs.getString("APT_PNP"));
					medico.setNroFicMed(rs.getString("NRO_FIC_MED"));
					vacaciones.setIdPVac(rs.getInt("ID_P_VAC"));
					vacaciones.setIniVac(rs.getDate("INI_VAC"));
					vacaciones.setFinVac(rs.getDate("FIN_VAC"));
					vacaciones.setCantVac(rs.getString("CANT_VAC"));
					franco.setIdAut(rs.getInt("ID_AUT"));
					franco.setDiasFranco(rs.getString("DIAS_FRANCO"));
					franco.setMes(rs.getString("MES"));
					franco.setAnio(rs.getString("ANIO"));
					blobarma=rs.getBytes("blobarma");
					blobvacaciones=rs.getBytes("blobvacaciones");
					blobfranco=rs.getBytes("blobfranco");
					blobmedico=rs.getBytes("blobmedico");
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query consultapreinscripcionxCip: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		
		
		if (persona!=null) {
			String fotoper=null;
			fotoper=LogicaUsuario.getInstance().getfoto(Cip);
			Gson gson = new Gson();
			json = gson.toJson(persona);
			array.add(json);
			json = gson.toJson(preinscripcion);
			array.add(json);
			json = gson.toJson(arma);
			array.add(json);
			json = gson.toJson(medico);
			array.add(json);
			
			if (preinscripcion.getModPre().equals("VACACIONES")) {
				json = gson.toJson(vacaciones);
				array.add(json);	
			}else {
				json = gson.toJson(franco);
				array.add(json);	
			}
			
			Base64.Encoder code = Base64.getEncoder();
			String imgArma=null;
			if (blobarma!=null) {
			imgArma = code.encodeToString(blobarma);	
			}
			json = gson.toJson(imgArma);
			array.add(json);
			
			if (preinscripcion.getModPre().equals("VACACIONES")) {
			String imgVaca =null;
			if (blobvacaciones!=null) {
			imgVaca = code.encodeToString(blobvacaciones);	
			}
			json = gson.toJson(imgVaca);
			array.add(json);
			}
			
			if (preinscripcion.getModPre().equals("FRANCO")) {
			String imgFranco =null;
			if (blobfranco!=null) {
			imgFranco = code.encodeToString(blobfranco);	
			}			
			json = gson.toJson(imgFranco);
			array.add(json);
			}
			String imgMedico =null;
			
			
			if (blobmedico!=null) {
				imgMedico = code.encodeToString(blobmedico);	
			}
			json = gson.toJson(imgMedico);
			array.add(json);
			
			
			if (fotoper!=null) {
				respuesta=array.toString()+"$$$$$"+fotoper;
			}else {
				respuesta=array.toString();
			}
	
		}else {
			respuesta="NOK";
		}
		return respuesta;
	}

	@Override
	public boolean inscribir(String id_prein, String tipo, String id_per, String id_autorizacion, String id_arma,
			String id_ficha, String Usuario) {
		int estado=0;
		boolean res=false;
		
		String query = "UPDATE OCEX_PRE_INSC\r\n" + 
				"SET FLAG_PRE             ='0'\r\n" + 
				"WHERE ID_PRE      = ?";
		String query2 = "INSERT\r\n" + 
				"INTO OCEX_INSCR\r\n" + 
				"  (\r\n" + 
				"    ID_PER,\r\n" + 
				"    ID_PRE,\r\n" + 
				"    USU_REG\r\n" + 
				"  )\r\n" + 
				"  VALUES\r\n" + 
				"  (\r\n" + 
				"   ?,\r\n" + 
				"    ?,\r\n" + 
				"    ?\r\n" + 
				"  )";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query2);
				ps.setInt(1, Integer.parseInt(id_per.trim()));
				ps.setInt(2, Integer.parseInt(id_prein.trim()));
				ps.setString(3, Usuario);
				estado= ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Excepcion en query consultainscripcionok: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		 emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		 em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cOn = em.unwrap(java.sql.Connection.class);
		if (estado>0) {
			if (cn != null) {
				try {
					PreparedStatement ps = cOn.prepareStatement(query);
					ps.setInt(1, Integer.parseInt(id_prein.trim()));
					estado= ps.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Excepcion en query consultainscripcionok: " + e.toString());
				} finally {
					em.getTransaction().commit();
					em.close();
					emf.close();
				}
			}
			
				
				res=true;	
			}
		
		
		
		if (estado>0) {
			res=true;
		}
		return res;
	}
}
