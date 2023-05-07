package edu.ucam.acciones;

import javax.naming.NamingException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionEditarPartido extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("idPartido") != null) {
			request.getServletContext().setAttribute("partido", request.getParameter("idPartido"));
		} else {
			request.getServletContext().setAttribute("MSGP", "No se puede editar el partido");
			return "/Control?ID_ACCION=LISTARPARTIDO";
		}
		return "editarPartido.jsp?idPartido="+request.getParameter("idPartido");
	}
	
}
