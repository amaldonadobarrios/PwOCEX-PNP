package service.impl;

import dao.OcexPerPnpDAO;
import dao.impl.OcexPerPnpDAOImpl;
import entity.OcexPerPnp;
import service.OcexPerPnpService;

public class OcexPerPnpServiceImpl implements OcexPerPnpService {
	OcexPerPnpDAO dao=new OcexPerPnpDAOImpl();
	@Override
	public int save(OcexPerPnp persona) {
		// TODO Auto-generated method stub
		return dao.save(persona);
	}

	@Override
	public int update(OcexPerPnp persona) {
		// TODO Auto-generated method stub
		return dao.update(persona);
	}

	@Override
	public OcexPerPnp getOcexPerPnp(String id_persona) {
		// TODO Auto-generated method stub
		return dao.getOcexPerPnp(id_persona);
	}

}
