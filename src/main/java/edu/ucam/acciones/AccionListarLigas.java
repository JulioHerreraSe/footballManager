package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.LigaDAO;
import edu.ucam.bd.LigaDAOSQL;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionListarLigas extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		
		request.getServletContext().setAttribute("ligas", getLigaDAO().listar());
		
		// Ponemos la ruta a la que redireccionaremos
		return "ligas.jsp";
	}

	public LigaDAO getLigaDAO() throws NamingException {
		return new LigaDAOSQL();
	}
	
}
