package logica;

import service.OcexPreinscripcionService;
import service.impl.OcexPreinscripcionServiceImpl;

public class LogicaPreinscripcion {
	// PATRON SINGLETON INI
	private static LogicaPreinscripcion instance = null;

	public static synchronized LogicaPreinscripcion getInstance() {
		if (instance == null) {
			instance = new LogicaPreinscripcion();
		}
		return instance;
	}

	private LogicaPreinscripcion() {
	}

	// PATRON SINGLETON FIN

	public boolean Grabar_Preinscripcion(String tipo, String fechainivac, String txtdiasvac, String fechafinvac,
			String fechainiservicio, String txtdiasservicio, String fechafinservicio, String diasfranco,
			String messervicio, String añoservicio, String id_fichero1, String aptitud, String nrofichamedica,
			String pistola, String serie, String marca, String calibre, String caf, String municion, String nrorevista,
			String unidadrevista, String cuenta, String telefono, String domicilio, int idPersona,
			String id_fichero0, String id_fichero2, String id_fichero3,String usuario) {
		OcexPreinscripcionService serv = new OcexPreinscripcionServiceImpl();
		return serv.SP_RegistrarPreinscripcion(tipo, fechainivac, txtdiasvac, fechafinvac,
				fechainiservicio, txtdiasservicio, fechafinservicio, diasfranco, messervicio, añoservicio, id_fichero1,
				aptitud, nrofichamedica, pistola, serie, marca, calibre, caf, municion, nrorevista, unidadrevista,
				cuenta, telefono, domicilio, idPersona, id_fichero0, id_fichero2, id_fichero3, usuario );
	}
	
	public int  consultainscripcionok(int id_per) {
		int i=0;
		OcexPreinscripcionService service =new OcexPreinscripcionServiceImpl();
		i=service.consultainscripcionok(id_per);
		return i;
	}

}
