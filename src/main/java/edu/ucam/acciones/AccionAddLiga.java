package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.LigaDAO;
import edu.ucam.bd.LigaDAOSQL;
import edu.ucam.pojos.Liga;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionAddLiga extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("nombre") != null) {
			String nombre = request.getParameter("nombre");
			
			getLigaDAO().insertar(new Liga(nombre));
			
			request.getServletContext().setAttribute("MSGL", "Liga Añadida");
		} else {
			request.getServletContext().setAttribute("MSGL", "Error al añadir la liga");
		}
		
		request.getServletContext().setAttribute("ligas", getLigaDAO().listar());
		
		return "/Control?ID_ACCION=LISTARLIGAS";
	}
	
	public LigaDAO getLigaDAO() throws NamingException {
		return new LigaDAOSQL();
	}

}
