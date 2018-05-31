package service.impl;

import dao.OcexPreinscripcionDAO;
import dao.impl.OcexPreinscripcionDAOImpl;
import service.OcexPreinscripcionService;

public class OcexPreinscripcionServiceImpl implements OcexPreinscripcionService {
OcexPreinscripcionDAO dao=new OcexPreinscripcionDAOImpl();
	@Override
	public boolean SP_RegistrarPreinscripcion(String tipo, String fechainivac, String txtdiasvac, String fechafinvac,
			String fechainiservicio, String txtdiasservicio, String fechafinservicio, String diasfranco,
			String messervicio, String añoservicio, String id_fichero1, String aptitud, String nrofichamedica,
			String pistola, String serie, String marca, String calibre, String caf, String municion, String nrorevista,
			String unidadrevista, String cuenta, String telefono, String domicilio,int idPersona,
			String id_fichero0, String id_fichero2, String id_fichero3,String usuario) {
		// TODO Auto-generated method stub
		return dao.SP_RegistrarPreinscripcion(tipo, fechainivac, txtdiasvac, fechafinvac,
				fechainiservicio, txtdiasservicio, fechafinservicio, diasfranco, messervicio, añoservicio, id_fichero1,
				aptitud, nrofichamedica, pistola, serie, marca, calibre, caf, municion, nrorevista, unidadrevista,
				cuenta, telefono, domicilio, idPersona,  id_fichero0, id_fichero2, id_fichero3,usuario);
	}
	@Override
	public int consultainscripcionok(int id_per) {
		// TODO Auto-generated method stub
		return dao.consultainscripcionok(id_per);
	}

}
