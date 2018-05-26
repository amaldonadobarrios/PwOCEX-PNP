package logica;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.tempuri.ClsDatos;
import org.tempuri.ServiceLocator;

import entity.OcexPerPnp;
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
		OcexPerPnp persona=null;
		try {
			objDatos = objLocator.getServiceSoap().recuperaUsuarioExisteAD(usu, pass);
		} catch (RemoteException | ServiceException e) {
			// TODO Auto-generated catch block
		}
		if (objDatos != null) {
			cip = objDatos.getCarnetPNP();
		}
		if (cip != null) {
			persona=new OcexPerPnp();
			persona.setCipPer(objDatos.getCarnetPNP());
			persona.setCorreoPnp(objDatos.getEmail());
			HttpSession sesion = req.getSession();
			sesion.setAttribute("persona", persona);
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
		OcexPerPnp persona= new OcexPerPnp();
		OcexPerPnp personabd;
		personabd=LogicPersona.getInstance().getOcexPersona(cip);
		Aguila6Service dao = new Aguila6ServiceImpl();
		UsuarioAguila6 usu = new UsuarioAguila6();
		usu = dao.getAguila6bd(cip);
		HttpSession sesion = req.getSession();
		persona= (OcexPerPnp) sesion.getAttribute("persona");
		persona.setApeMatPer(usu.getApellidomat());
		persona.setApePatPer(usu.getApellidopat());
		persona.setNomPer(usu.getNombre());
		persona.setDniPer(usu.getDni());
		persona.setFecNac(usu.getFechanac());
		persona.setGradoPer(usu.getGrado());
		persona.setGenPer(usu.getSexo());
		persona.setNomUniPer(usu.getUnidad());
		if (personabd!=null) {
			persona.setIdPer(personabd.getIdPer());	
		}
		sesion.setAttribute("persona", persona);
		sesion.setAttribute("unidad", usu.getUnidad());
		sesion.setAttribute("sexo", usu.getSexo());
		sesion.setAttribute("dni", usu.getDni());
		return usu;

	}
	public boolean UsuarioActive(String cip) throws RemoteException, ServiceException {
		boolean estado = false;
		ServiceLocator objLocator = new ServiceLocator();
		estado = objLocator.getServiceSoap().existeUsuarioLDAP(cip);
		return estado;
	}
	public ClsDatos GetUsuarioActive(String cip) throws RemoteException, ServiceException {
		String rpta = null;
		ClsDatos objDatos = new ClsDatos();
		ServiceLocator objLocator = new ServiceLocator();
		objDatos = objLocator.getServiceSoap().recuperaDatosUsuarioExisteLDAP(cip);
		return objDatos;
	}
	public  UsuarioAguila6 getAguilabd(String cip) throws Exception {
		Aguila6Service dao = new Aguila6ServiceImpl();
		UsuarioAguila6 usu = new UsuarioAguila6();
		String ncip=String.format("%08d", Integer.parseInt(cip));
		try {
			usu = dao.getAguila6bd(ncip);
		} catch (Exception e) {
			usu=null;
		}
		return usu;
	}
	
	

}
