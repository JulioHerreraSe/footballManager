package edu.ucam.bd;

import java.util.List;

import javax.naming.NamingException;

import edu.ucam.pojos.Club;

public abstract class ClubDAO {
	public abstract List<Club> listar() throws NamingException;
	public abstract Club buscar(Club club);
	public abstract void insertar(Club club);
	public abstract void actualizar(Club club);
	public abstract void eliminar(Club club);
}
