package logica;

import entity.OcexPerPnp;
import service.OcexPerPnpService;
import service.impl.OcexPerPnpServiceImpl;

public class LogicPersona {
	// PATRON SINGLETON INI
	private static LogicPersona instance = null;

	public static synchronized LogicPersona getInstance() {
		if (instance == null) {
			instance = new LogicPersona();
		}
		return instance;
	}

	private LogicPersona() {
	}

	// PATRON SINGLETON FIN
	public OcexPerPnp  getOcexPersona(String cip) {
		OcexPerPnpService serv=new OcexPerPnpServiceImpl();
		OcexPerPnp per=serv.getOcexPerPnp(cip);
		return per;
	}

}
