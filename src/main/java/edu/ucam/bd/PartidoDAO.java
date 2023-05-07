package edu.ucam.bd;

import java.util.List;

import javax.naming.NamingException;

import edu.ucam.pojos.Partido;

public abstract class PartidoDAO {
	public abstract List<Partido> listar() throws NamingException;
	public abstract Partido buscar(Partido partido);
	public abstract void insertar(Partido partido);
	public abstract void actualizar(Partido partido);
	public abstract void eliminar(Partido partido);
}
