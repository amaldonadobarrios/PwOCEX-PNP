package dao;

import entity.OcexPerPnp;

public interface OcexPerPnpDAO {
public int save(OcexPerPnp persona);
public int update(OcexPerPnp persona);
public OcexPerPnp getOcexPerPnp(String cip);
}
