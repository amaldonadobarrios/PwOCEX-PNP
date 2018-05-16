package dao;

import java.io.IOException;

import entity.UsuarioAguila6;

public interface UsuarioDAO {
	public String img(String cip) throws IOException;
	public UsuarioAguila6 getEfectivoAguila6(String cip)throws Exception;

}
