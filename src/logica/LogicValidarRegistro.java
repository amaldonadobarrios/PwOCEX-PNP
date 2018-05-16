package logica;

public class LogicValidarRegistro {
	// PATRON SINGLETON INI
	private static LogicValidarRegistro instance = null;

	public static synchronized LogicValidarRegistro getInstance() {
		if (instance == null) {
			instance = new LogicValidarRegistro();
		}
		return instance;
	}

	private LogicValidarRegistro() {
	}
	// PATRON SINGLETON FIN
	
	
	public boolean ValidarRegistro() {
		boolean estado=true;
		//estado => consulltar a bd si esta habilitado el permiso
		return estado;
	}
}
