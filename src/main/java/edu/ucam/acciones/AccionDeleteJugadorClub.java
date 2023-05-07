package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.JugadorDAO;
import edu.ucam.bd.JugadorDAOSQL;
import edu.ucam.pojos.Jugador;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionDeleteJugadorClub extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("idJugador") != null) {
			Jugador jugador = getJugadorDAO().buscar(new Jugador(Integer.parseInt(request.getParameter("idJugador"))));
			jugador.setIdClub(1);
			getJugadorDAO().actualizar(jugador);
			request.getServletContext().setAttribute("MSGC", "Jugador quitado del equipo");
			request.getServletContext().setAttribute("jugadores", getJugadorDAO().listar());
		} else {
			request.getServletContext().setAttribute("MSGC", "No se puede quitar al jugador del equipo");
		}
		
		request.getServletContext().setAttribute("jugadores", getJugadorDAO().listar());
		
		return "/Control?ID_ACCION=LISTARCLUBS";
	}
	
	public JugadorDAO getJugadorDAO() throws NamingException {
		return new JugadorDAOSQL();
	}
	

}
