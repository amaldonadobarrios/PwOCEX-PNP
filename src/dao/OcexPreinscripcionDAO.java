package dao;

import java.io.IOException;

public interface OcexPreinscripcionDAO {
	public boolean  SP_RegistrarPreinscripcion(String tipo, String fechainivac, String txtdiasvac, String fechafinvac,
			String fechainiservicio, String txtdiasservicio, String fechafinservicio, String diasfranco,
			String messervicio, String añoservicio, String id_fichero1, String aptitud, String nrofichamedica,
			String pistola, String serie, String marca, String calibre, String caf, String municion, String nrorevista,
			String unidadrevista, String cuenta, String telefono, String domicilio,int idPersona,
			String id_fichero0, String id_fichero2, String id_fichero3,String usuario);

public int consultainscripcionok(int id_per);
public String consultapreinscripcionxCip(String Cip) throws IOException;
public boolean inscribir(String id_prein,String tipo, String id_per, String id_autorizacion, String id_arma, String id_ficha, String Usuario);
}



