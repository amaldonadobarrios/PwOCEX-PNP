package service;

import entity.OcexCharla;

public interface OcexCharlaService {
	public boolean saveCharla(OcexCharla charla);
	public int TieneCharlaActiva(String cip);
}
