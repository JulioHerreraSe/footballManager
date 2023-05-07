package edu.ucam.acciones;

import javax.naming.NamingException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionLogout extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		// Añadimos el mensaje de comunicación con el cliente
		request.getServletContext().setAttribute("MSG_ERROR", "");
		// Quitamos al usuario de la sesion
		request.getSession().setAttribute("user", null);
		// Ponemos la ruta a la que redireccionaremos
		return "index.jsp";
	}

}
