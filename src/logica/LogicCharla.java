package logica;

import entity.OcexCharla;
import service.OcexCharlaService;
import service.impl.OcexCharlaServiceImpl;

public class LogicCharla {
	// PATRON SINGLETON INI
	private static LogicCharla instance = null;

	public static synchronized LogicCharla getInstance() {
		if (instance == null) {
			instance = new LogicCharla();
		}
		return instance;
	}

	private LogicCharla() {
	}

	// PATRON SINGLETON FIN
	
	public boolean guardarCharla(OcexCharla charla) {
		boolean rpta=false;
		OcexCharlaService service= new OcexCharlaServiceImpl();
		rpta=service.saveCharla(charla);
		return rpta;
	}
	
	

}
