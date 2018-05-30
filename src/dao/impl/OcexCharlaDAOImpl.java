package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import dao.OcexCharlaDAO;
import entity.OcexCharla;
import entity.OcexPerPnp;

public class OcexCharlaDAOImpl implements OcexCharlaDAO {

	
	@Override
	public boolean saveCharla(OcexCharla charla) {
		System.out.println("Entre a saveCharla");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    em.persist(charla);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	    if (charla.getIdCharla()>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int TieneCharlaActiva(String cip) {
		int id_charla = 0;
		String query = "SELECT ID_CHARLA\r\n" + 
				"FROM OCEX_CHARLA WHERE  CIP_PER=? AND VIG_CHAR > to_date(SYSDATE) AND  FLAG_CHARLA='1'";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1, cip.trim());
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					id_charla=rs.getInt("ID_CHARLA");
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query obtener id de charla x cip: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return id_charla;
	}

}
