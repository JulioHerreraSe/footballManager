package edu.ucam.acciones;

import javax.naming.NamingException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionInsertarPartidoFase1 extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		
		return "insertarPartidoFase1.jsp";
	}

}
