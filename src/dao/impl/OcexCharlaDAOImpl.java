package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import dao.OcexCharlaDAO;
import entity.OcexCharla;

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

}
