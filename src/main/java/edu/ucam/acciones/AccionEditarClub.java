package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAO;
import edu.ucam.bd.ClubDAOSQL;
import edu.ucam.pojos.Club;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionEditarClub extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		// Comprobamos que el parametro id no este a nulo
		if(request.getParameter("idClub") != null) {
			// Cargamos en el contexto el club desde la base de datos
			request.getServletContext().setAttribute("club", getClubDAO().buscar(new Club(Integer.parseInt(request.getParameter("idClub")))));
		} else {
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGC", "No se puede editar al club");
			// Ponemos la ruta a la que redireccionaremos
			return "/Control?ID_ACCION=LISTARCLUBS";
		}
		// Ponemos la ruta a la que redireccionaremos
		return "editarClub.jsp";
	}

	public ClubDAO getClubDAO() throws NamingException {
		return new ClubDAOSQL();
	}
	
}
