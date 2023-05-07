package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAO;
import edu.ucam.bd.ClubDAOSQL;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionListarClubs extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		// Ponemos a nulo el atributo jugador
		request.getServletContext().setAttribute("jugador", null);
		// Ponemos a nulo el atributo club
		request.getServletContext().setAttribute("club", null);
		
		request.getServletContext().setAttribute("clubs", getClubDAO().listar());
		
		// Ponemos la ruta a la que redireccionaremos
		return "clubs.jsp";
	}

	public ClubDAO getClubDAO() throws NamingException {
		return new ClubDAOSQL();
	}
	
}
