package service.impl;

import dao.OcexFicheroDAO;
import dao.impl.OcexFicheroDAOImpl;
import entity.OcexFicher;
import service.OcexFicheroService;

public class OcexFicheroServiceImpl implements OcexFicheroService {
	OcexFicheroDAO dao= new OcexFicheroDAOImpl();
	@Override
	public int Grabar(OcexFicher obj) {
		// TODO Auto-generated method stub
		return dao.Grabar(obj);
	}

	@Override
	public String RutaVerPDF(int id_fichero) {
		// TODO Auto-generated method stub
		return dao.RutaVerPDF(id_fichero);
	}

	@Override
	public OcexFicher Download(int id_fichero) {
		// TODO Auto-generated method stub
		return dao.Download(id_fichero);
	}

}
