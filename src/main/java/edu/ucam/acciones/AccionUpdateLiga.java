package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.LigaDAO;
import edu.ucam.bd.LigaDAOSQL;
import edu.ucam.pojos.Liga;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionUpdateLiga extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		// Comprobamos que los parametros no sean nulos
		if(request.getParameter("idLiga") != null && request.getParameter("nombre") != null) {
			// Recogemos los parametros
			int id = Integer.parseInt(request.getParameter("idLiga"));
			String nombre = request.getParameter("nombre");
			// Actualizamos el club en la BD
			getLigaDAO().actualizar(new Liga(id,nombre));
			// Ponemos a nulo el atributo club
			request.getServletContext().setAttribute("liga", null);
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGL", "Liga Actualizada");
		} else {
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGL", "No se ha podido actualizar la liga");
		}
		
		request.getServletContext().setAttribute("ligas", getLigaDAO().listar());
		
		// Ponemos la ruta a la que redireccionaremos
		return "/Control?ID_ACCION=LISTARLIGAS";
	}
	
	public LigaDAO getLigaDAO() throws NamingException {
		return new LigaDAOSQL();
	}

}
