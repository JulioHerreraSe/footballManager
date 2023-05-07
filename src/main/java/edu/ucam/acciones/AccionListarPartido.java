package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.PartidoDAO;
import edu.ucam.bd.PartidoDAOSQL;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionListarPartido extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		
		request.getServletContext().setAttribute("partidos", getPartidoDAO().listar());
		
		// Ponemos la ruta a la que redireccionaremos
		return "partidos.jsp";
	}
	
	public PartidoDAO getPartidoDAO() throws NamingException {
		return new PartidoDAOSQL();
	}

}
