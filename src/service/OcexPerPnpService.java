package service;

import entity.OcexPerPnp;

public interface OcexPerPnpService {
	public int save(OcexPerPnp persona);
	public int update(OcexPerPnp persona);
	public OcexPerPnp getOcexPerPnp(String id_persona);
}
