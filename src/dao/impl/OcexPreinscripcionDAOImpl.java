package dao.impl;



import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import dao.OcexPreinscripcionDAO;
import entity.OcexPerPnp;
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
	public String consultapreinscripcionxCip(String Cip) {
		String  respuesta = null;
		String tipo ;
		String fechainivac;
		String txtdiasvac ;
		String fechafinvac;
		String fechainiservicio;
		String txtdiasservicio ;
		String fechafinservicio;
		String diasfranco;
		String messervicio;
		String añoservicio;
		String id_fichero1 ;
		String aptitud ;
		String nrofichamedica ;
		String pistola ;
		String serie ;
		String marca ;
		String calibre; 
		String caf ;
		String municion;
		String nrorevista ;
		String unidadrevista;
		String cuenta ;
		String telefono ;
		String domicilio ;
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
				"  FI_ARMA.IMAGE_FICHER,\r\n" + 
				"  MEDICO.ID_FIC_MED,\r\n" + 
				"  MEDICO.APT_PNP,\r\n" + 
				"  MEDICO.NRO_FIC_MED,\r\n" + 
				"  FI_MEDICO.IMAGE_FICHER,\r\n" + 
				"  VACACIONES.ID_P_VAC,\r\n" + 
				"  VACACIONES.ID_P_VAC,\r\n" + 
				"  VACACIONES.CANT_VAC,\r\n" + 
				"  VACACIONES.INI_VAC,\r\n" + 
				"  VACACIONES.FIN_VAC,\r\n" + 
				"  VACACIONES.FINI_CUS,\r\n" + 
				"  VACACIONES.FFIN_CUS,\r\n" + 
				"  FI_VACACIONES.IMAGE_FICHER,\r\n" + 
				"  FRANCO.ID_AUT,\r\n" + 
				"  FRANCO.DIAS_FRANCO,\r\n" + 
				"  FRANCO.MES,\r\n" + 
				"  FRANCO.ANIO,\r\n" + 
				"  FI_FRANCO.IMAGE_FICHER\r\n" + 
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
				"where  TO_CHAR(PRE.FECHA_REG, 'MM-YYYY')=TO_CHAR(SYSDATE, 'MM-YYYY') and PRE.usu_reg=? AND FRANCO.FECH_REG=PRE.FECHA_REG OR VACACIONES.FECHA_REG=PRE.FECHA_REG  ;\r\n" + 
				"\r\n" + 
				"";
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
				if (rs.next()) {
					//obtner datos
					
					
					
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query consultapreinscripcionxCip: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return respuesta;
	}
}
