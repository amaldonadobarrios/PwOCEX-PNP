package service.impl;

import dao.OcexCharlaDAO;
import dao.impl.OcexCharlaDAOImpl;
import entity.OcexCharla;
import service.OcexCharlaService;

public class OcexCharlaServiceImpl implements OcexCharlaService {
	OcexCharlaDAO dao = new OcexCharlaDAOImpl();

	@Override
	public boolean saveCharla(OcexCharla charla) {
		return dao.saveCharla(charla);
	}

	@Override
	public int TieneCharlaActiva(String cip) {
		// TODO Auto-generated method stub
		return dao.TieneCharlaActiva(cip);
	}

}
