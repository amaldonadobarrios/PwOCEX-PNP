package service.impl;

import java.io.IOException;

import dao.UsuarioDAO;
import dao.impl.UsuarioDAOImpl;
import entity.UsuarioAguila6;
import service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
UsuarioDAO dao= new UsuarioDAOImpl();
	@Override
	public String img(String cip) throws IOException {
		// TODO Auto-generated method stub
		return dao.img(cip);
	}
	@Override
	public UsuarioAguila6 getEfectivoAguila6(String cip) throws Exception {
		// TODO Auto-generated method stub
		return dao.getEfectivoAguila6(cip);
	}
	
	

	
}
