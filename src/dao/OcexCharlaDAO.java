package dao;

import entity.OcexCharla;

public interface OcexCharlaDAO {
public boolean saveCharla(OcexCharla charla);
public int TieneCharlaActiva(String cip);
}
