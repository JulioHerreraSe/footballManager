package edu.ucam.bd;

import java.util.List;

import javax.naming.NamingException;

import edu.ucam.pojos.Liga;

public abstract class LigaDAO {
	public abstract List<Liga> listar() throws NamingException;
	public abstract Liga buscar(Liga liga);
	public abstract void insertar(Liga liga);
	public abstract void actualizar(Liga liga);
	public abstract void eliminar(Liga liga);
}
