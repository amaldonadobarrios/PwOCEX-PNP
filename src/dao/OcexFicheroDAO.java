package dao;

import entity.OcexFicher;

public interface OcexFicheroDAO {
	public int Grabar(OcexFicher obj);
	public String RutaVerPDF(int id_fichero);
	public OcexFicher Download (int id_fichero);
}
