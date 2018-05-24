package logica;

import entity.OcexFicher;
import service.OcexFicheroService;
import service.impl.OcexFicheroServiceImpl;

public class LogicFichero {
	// PATRON SINGLETON INI
	private static LogicFichero instance = null;

	public static synchronized LogicFichero getInstance() {
		if (instance == null) {
			instance = new LogicFichero();
		}
		return instance;
	}

	private LogicFichero() {
	}
	// PATRON SINGLETON FIN
	public int GrabarFichero(OcexFicher obj) {
		OcexFicheroService ser=new OcexFicheroServiceImpl();
		int i=ser.Grabar(obj);
		if (i>0) {
			return i;
		}		
		return 0;
	}
	public String RutaVerPDF(int id_fichero) {
		OcexFicheroService ser=new OcexFicheroServiceImpl();
		return ser.RutaVerPDF(id_fichero);
	}
	public OcexFicher Download(int id_fichero) {
		OcexFicheroService ser=new OcexFicheroServiceImpl();
		return ser.Download(id_fichero);
	}
	
}
