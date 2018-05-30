package dao.impl;



import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import dao.OcexPreinscripcionDAO;
public class OcexPreinscripcionDAOImpl implements OcexPreinscripcionDAO {

	@Override
	public boolean SP_RegistrarPreinscripcion(String tipo, String fechainivac, String txtdiasvac, String fechafinvac,
			String fechainiservicio, String txtdiasservicio, String fechafinservicio, String diasfranco,
			String messervicio, String añoservicio, String id_fichero1, String aptitud, String nrofichamedica,
			String pistola, String serie, String marca, String calibre, String caf, String municion, String nrorevista,
			String unidadrevista, String cuenta, String telefono, String domicilio,int idPersona,
			String id_fichero0, String id_fichero2, String id_fichero3,String usuario) {
		System.out.println( " tipo   "  +   tipo     );
		System.out.println( " fechainivac   "  +    fechainivac    );
		System.out.println( " txtdiasvac   "  +     txtdiasvac   );
		System.out.println( "fechafinvac    "  +  fechafinvac      );
		System.out.println( "fechainiservicio    "  + fechainiservicio       );
		System.out.println( " txtdiasservicio   "  +  txtdiasservicio      );
		System.out.println( " diasfranco   "  +     diasfranco   );
		System.out.println( " messervicio   "  +  messervicio      );
		System.out.println( " añoservicio   "  +  añoservicio      );
		System.out.println( "aptitud    "  + aptitud       );
		System.out.println( " pistola   "  +   pistola     );
		System.out.println( " marca   "  +   marca     );
		System.out.println( " caf   "  +    caf    );
		System.out.println( " nrorevista   "  + nrorevista       );
		System.out.println( " cuenta   "  +    cuenta    );
		System.out.println( " domicilio   "  +   domicilio     );
		System.out.println( " id_fichero0   "  +  id_fichero0      );
		System.out.println( " id_fichero2   "  +   id_fichero2     );
		System.out.println( " id_fichero3   "  +  id_fichero3      );
		System.out.println( " idPersona   "  +    idPersona    );
		System.out.println( " usuario   "  +   usuario     );
		System.out.println( " id_fichero1   "  +   id_fichero1     );
		System.out.println( " nrofichamedica   "  +     nrofichamedica   );
		System.out.println( " serie   "  +  serie      );
		System.out.println( " calibre   "  +  calibre      );
		System.out.println( " municion   "  +   municion     );
		System.out.println( "  unidadrevista  "  + unidadrevista       );
		System.out.println( " telefono   "  +  telefono      );
		System.out.println( " id_persona   "  +     idPersona   );
		System.out.println( " fechafinservicio   "  + fechafinservicio       );
		
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
				 cs.setInt(2,idfichero1);
				 cs.setString(3,diasfranco);
				 cs.setString(4,messervicio);
				 cs.setString(5,añoservicio);
				 cs.setString(6,txtdiasvac);
				 cs.setString(7,fechainivac);
				 cs.setString(8,fechafinvac);
				 cs.setInt(9,idfichero0);
				 cs.setString(10,tipo);
				 cs.setString(11,nrorevista);
				 cs.setString(12,marca);
				 cs.setString(13,calibre);
				 cs.setString(14,pistola);
				 cs.setString(15,serie);
				 cs.setString(16,"DOS (02) CACERINAS");
				 cs.setString(17,caf);
				 cs.setString(18,municion);
				 cs.setInt(19,idfichero3);
				 cs.setString(20,unidadrevista);
				 cs.setString(21,aptitud);
				 cs.setString(22,nrofichamedica);
				 cs.setInt(23,idfichero2);
				 cs.setString(24,fechainiservicio);
				 cs.setString(25,fechafinservicio);
				 cs.setString(26,txtdiasservicio);
				 cs.setInt(27,idPersona);
				 cs.registerOutParameter(28,Types.VARCHAR);
				 cs.execute();	
				 dato = cs.getString(28);
			} catch (SQLException e) {
				System.out.println("Excepcion en call test(?,?,?): " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		System.out.println(" rpta OUT PARAMETER : " + dato);
		return rpta;	
	}

	

}
