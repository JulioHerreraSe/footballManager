package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.JugadorDAO;
import edu.ucam.bd.JugadorDAOSQL;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionListarJugadores extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		
		request.getServletContext().setAttribute("jugadores", getJugadorDAO().listar());
		
		return "jugadores.jsp";
	}
	
	public JugadorDAO getJugadorDAO() throws NamingException {
		return new JugadorDAOSQL();
	}

}
