package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.LigaDAO;
import edu.ucam.bd.LigaDAOSQL;
import edu.ucam.pojos.Liga;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionEditarLiga extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("idLiga") != null) {
			request.getServletContext().setAttribute("liga", getLigaDAO().buscar(new Liga(Integer.parseInt(request.getParameter("idLiga")))));
		} else {
			request.getServletContext().setAttribute("MSGC", "No se puede editar al jugador");
			return "/Control?ID_ACCION=LISTARLIGAS";
		}
		return "editarLiga.jsp";
	}
	
	public LigaDAO getLigaDAO() throws NamingException {
		return new LigaDAOSQL();
	}

}
