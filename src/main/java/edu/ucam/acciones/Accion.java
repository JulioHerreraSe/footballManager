package edu.ucam.acciones;

import javax.naming.NamingException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Accion {
	// PENE
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException;
}
