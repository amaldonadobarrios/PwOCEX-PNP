package logica;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.tempuri.ClsDatos;
import org.tempuri.ServiceLocator;

import entity.UsuarioAguila6;
import service.Aguila6Service;
import service.UsuarioService;
import service.impl.Aguila6ServiceImpl;
import service.impl.UsuarioServiceImpl;

public class LogicValidarAguila6 {
	// PATRON SINGLETON INI
	private static LogicValidarAguila6 instance = null;

	public static synchronized LogicValidarAguila6 getInstance() {
		if (instance == null) {
			instance = new LogicValidarAguila6();
		}
		return instance;
	}

	private LogicValidarAguila6() {
	}
	// PATRON SINGLETON FIN

	public boolean validar(String usu, String pass, HttpServletRequest req) throws IOException {
		boolean rpta = false;
		ClsDatos objDatos = new ClsDatos();
		ServiceLocator objLocator = new ServiceLocator();
		objDatos = null;
		String cip = null;
		try {
			objDatos = objLocator.getServiceSoap().recuperaUsuarioExisteAD(usu, pass);
		} catch (RemoteException | ServiceException e) {
			// TODO Auto-generated catch block
		}
		if (objDatos != null) {
			cip = objDatos.getCarnetPNP();
		}
		if (cip != null) {
			HttpSession sesion = req.getSession();
			sesion.setAttribute("usuario", objDatos.getGradoNombreApellidos());
			sesion.setAttribute("img64", getfoto(cip));
			sesion.setAttribute("ID", sesion.getId());
			sesion.setAttribute("CIP", cip);
			sesion.setMaxInactiveInterval(3000);
			rpta = true;
		}
		return rpta;
	}

	public String getfoto(String cip) throws IOException {
		String imgb64 = null;
		UsuarioService serv = new UsuarioServiceImpl();
		imgb64 = serv.img(cip);
		return imgb64;
	}

	public UsuarioAguila6 getUsuarioAguila6(String cip, HttpServletRequest req) throws Exception {
		Aguila6Service dao = new Aguila6ServiceImpl();
		UsuarioAguila6 usu = new UsuarioAguila6();
		usu = dao.getAguila6bd(cip);
		System.out.println(usu.toString());
		HttpSession sesion = req.getSession();
		sesion.setAttribute("unidad", usu.getUnidad());
		sesion.setAttribute("sexo", usu.getSexo());
		return usu;

	}

}
