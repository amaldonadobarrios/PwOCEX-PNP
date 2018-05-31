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
}
