package test;

import entity.UsuarioAguila6;
import service.Aguila6Service;
import service.impl.Aguila6ServiceImpl;

public class Test {

	public static void main(String[] args) throws Exception {
		Aguila6Service dao = new Aguila6ServiceImpl();
		UsuarioAguila6 usu = new UsuarioAguila6();
		usu = dao.getAguila6bd("31424836");
		System.out.println(usu.toString());

	}

}
