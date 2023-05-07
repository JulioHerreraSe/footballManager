package edu.ucam.bd;

import java.util.List;

import javax.naming.NamingException;

import edu.ucam.pojos.Jugador;

public abstract class JugadorDAO {
	public abstract List<Jugador> listar() throws NamingException;
	public abstract Jugador buscar(Jugador jugador);
	public abstract void insertar(Jugador jugador);
	public abstract void actualizar(Jugador jugador);
	public abstract void eliminar(Jugador jugador);
}
