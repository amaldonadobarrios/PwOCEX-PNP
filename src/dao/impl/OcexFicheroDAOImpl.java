package dao.impl;

import java.util.Base64;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.OcexFicheroDAO;
import entity.OcexFicher;

public class OcexFicheroDAOImpl implements OcexFicheroDAO {

	@Override
	public int Grabar(OcexFicher obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return (int) obj.getIdFicher();
	}

	@Override
	public String RutaVerPDF(int id_fichero) {
		String codeB64 =null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		OcexFicher u = null;
		u = em.getReference(OcexFicher.class, id_fichero);
		em.getTransaction().commit();
		em.close();
		emf.close();
		Base64.Encoder code = Base64.getEncoder();
		codeB64 = code.encodeToString(u.getImageFicher());
		return codeB64+"||"+u.getTipFicher();
	}

	@Override
	public OcexFicher Download(int id_fichero) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		OcexFicher u = null;
		u = em.getReference(OcexFicher.class, id_fichero);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return u;
	}

}
