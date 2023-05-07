package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.JugadorDAO;
import edu.ucam.bd.JugadorDAOSQL;
import edu.ucam.pojos.Jugador;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionDeleteJugador extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("idJugador") != null) {
			Jugador jugador = getJugadorDAO().buscar(new Jugador(Integer.parseInt(request.getParameter("idJugador"))));
			if(jugador.getIdClub() != 1)
			{
				request.getServletContext().setAttribute("MSGJ", "No se puede eliminar al jugador porque está en un club");
				return "/Control?ID_ACCION=LISTARJUGADORES";
			}
			getJugadorDAO().eliminar(jugador);
			request.getServletContext().setAttribute("MSGJ", "Jugador eliminado");
		} else {
			request.getServletContext().setAttribute("MSGJ", "No se ha podido eliminar al jugador");
		}
		
		request.getServletContext().setAttribute("jugadores", getJugadorDAO().listar());
		
		return "/Control?ID_ACCION=LISTARJUGADORES";
	}

	public JugadorDAO getJugadorDAO() throws NamingException {
		return new JugadorDAOSQL();
	}
	
}
