package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.OcexPerPnpDAO;
import entity.OcexPerPnp;

public class OcexPerPnpDAOImpl implements OcexPerPnpDAO {

	@Override
	public int save(OcexPerPnp persona) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(persona);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return (int) persona.getIdPer();
	}

	@Override
	public int update(OcexPerPnp persona) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		OcexPerPnp u = null;
		u = em.getReference(OcexPerPnp.class, persona.getIdPer());
//		u.setApeMat(obj.getApeMat());
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return (int) u.getIdPer();
	}

	@Override
	public OcexPerPnp getOcexPerPnp(String cip) {
		OcexPerPnp persona = null;
		String query = "SELECT ID_PER,\r\n" + 
				"  NOM_PER,\r\n" + 
				"  APE_PAT_PER,\r\n" + 
				"  APE_MAT_PER,\r\n" + 
				"  GRADO_PER,\r\n" + 
				"  DOM_PER,\r\n" + 
				"  NOM_UNI_PER,\r\n" + 
				"  FEC_NAC,\r\n" + 
				"  GEN_PER,\r\n" + 
				"  DNI_PER,\r\n" + 
				"  TEL_CEL_PER,\r\n" + 
				"  CTA_AHOR_PER,\r\n" + 
				"  CIP_PER,\r\n" + 
				"  FLAG_PER_PNP,\r\n" + 
				"  CORREO_PNP,\r\n" + 
				"  FECHA_REG,\r\n" + 
				"  USU_REG\r\n" + 
				"FROM OCEX_PER_PNP where cip_per=?";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PwOCEX-PNP");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		java.sql.Connection cn = em.unwrap(java.sql.Connection.class);
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(query);
				ps.setString(1, cip.trim());
				ResultSet rs = ps.executeQuery();
				persona = new OcexPerPnp();
				if (rs.next()) {
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
					persona.setCtaAhorPer(rs.getString("CTA_AHOR_PER"));
					persona.setCipPer(rs.getString("CIP_PER"));
					persona.setFlagPerPnp(rs.getString("FLAG_PER_PNP"));
					persona.setCorreoPnp(rs.getString("CORREO_PNP"));
					persona.setUsuReg(rs.getString("USU_REG"));
				}
			} catch (SQLException e) {
				System.out.println("Excepcion en query obtenercodigo de unidad: " + e.toString());
			} finally {
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		}
		return persona;
	}

}
