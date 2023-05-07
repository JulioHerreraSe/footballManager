package edu.ucam.bd;

import java.util.List;

import javax.naming.NamingException;

import edu.ucam.pojos.User;

public abstract class UserDAO {
	public abstract List<User> listar() throws NamingException;
	public abstract User buscar(User user);
	public abstract void insertar(User user);
	public abstract void actualizar(User user);
	public abstract void eliminar(User user);
	public abstract int Validar(User user) throws NamingException;
}
