package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAO;
import edu.ucam.bd.ClubDAOSQL;
import edu.ucam.pojos.Club;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionUpdateClub extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		// Comprobamos que los parametros no sean nulos
		if(request.getParameter("idClub") != null && request.getParameter("nombre") != null && request.getParameter("idLiga") != null) {
			// Recogemos los parametros
			int id = Integer.parseInt(request.getParameter("idClub"));
			String nombre = request.getParameter("nombre");
			int idLiga = Integer.parseInt(request.getParameter("idLiga"));
			// Actualizamos el club en la BD
			getClubDAO().actualizar(new Club(id,nombre,idLiga));
			// Ponemos a nulo el atributo club
			request.getServletContext().setAttribute("club", null);
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGC", "Club Actualizado");
		} else {
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGC", "No se ha podido actualizar al Club");
		}
		
		request.getServletContext().setAttribute("clubs", getClubDAO().listar());
		
		// Ponemos la ruta a la que redireccionaremos
		return "/Control?ID_ACCION=LISTARCLUBS";
	}
	
	public ClubDAO getClubDAO() throws NamingException {
		return new ClubDAOSQL();
	}

}
