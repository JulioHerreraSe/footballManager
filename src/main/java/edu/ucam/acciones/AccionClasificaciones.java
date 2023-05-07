package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAO;
import edu.ucam.bd.ClubDAOSQL;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionClasificaciones extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		
		request.getServletContext().setAttribute("clubs", getClubDAO().listar());
		
		return "clasificaciones.jsp?idLiga="+request.getParameter("idLiga");
	}

	public ClubDAO getClubDAO() throws NamingException {
		return new ClubDAOSQL();
	}
	
}
