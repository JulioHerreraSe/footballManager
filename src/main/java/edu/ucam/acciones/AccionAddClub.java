package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAO;
import edu.ucam.bd.ClubDAOSQL;
import edu.ucam.pojos.Club;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionAddClub extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		// Comprobamos que los parametros no sean nulos
		if(request.getParameter("nombre") != null && request.getParameter("idLiga") != null ) {
			// Recogemos los parametros
			String nombre = request.getParameter("nombre");
			int idLiga = Integer.parseInt(request.getParameter("idLiga"));
			// Insertamos en la base de datos
			getClubDAO().insertar(new Club(nombre, idLiga));
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGC", "Club Añadido");
		} else {
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGC", "Error al añadir el Club");
		}
		
		request.getServletContext().setAttribute("clubs", getClubDAO().listar());
		
		// Ponemos la ruta a la que redireccionaremos
		return "/Control?ID_ACCION=LISTARCLUBS";
	}

	public ClubDAO getClubDAO() throws NamingException {
		return new ClubDAOSQL();
	}
	
}
