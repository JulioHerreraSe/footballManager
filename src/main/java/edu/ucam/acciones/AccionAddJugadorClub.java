package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAO;
import edu.ucam.bd.ClubDAOSQL;
import edu.ucam.bd.JugadorDAO;
import edu.ucam.bd.JugadorDAOSQL;
import edu.ucam.pojos.Jugador;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionAddJugadorClub extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("idClub") != null && request.getParameter("idJugador") != null ) {
			if(Integer.parseInt(request.getParameter("idClub")) != 0 && Integer.parseInt(request.getParameter("idJugador")) != 0) {
				Jugador jugador = getJugadorDAO().buscar(new Jugador(Integer.parseInt(request.getParameter("idJugador"))));
				jugador.setIdClub(Integer.parseInt(request.getParameter("idClub")));
				getJugadorDAO().actualizar(jugador);
				request.getServletContext().setAttribute("MSGC", "Jugador añadido alequipo");
				request.getServletContext().setAttribute("jugadores", getJugadorDAO().listar());
			} else {
				request.getServletContext().setAttribute("MSGC", "Debes seleccionar club y jugador");
			}
		} else {
			request.getServletContext().setAttribute("MSGC", "No se puede añadir al jugador al club");
		}
		
		request.getServletContext().setAttribute("clubs", getClubDAO().listar());
		request.getServletContext().setAttribute("Jugadores", getJugadorDAO().listar());
		
		return "/Control?ID_ACCION=LISTARCLUBS";
	}

	public JugadorDAO getJugadorDAO() throws NamingException {
		return new JugadorDAOSQL();
	}
	
	public ClubDAO getClubDAO() throws NamingException {
		return new ClubDAOSQL();
	}
	
}
