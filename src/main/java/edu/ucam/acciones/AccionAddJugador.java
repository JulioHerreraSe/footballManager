package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.JugadorDAO;
import edu.ucam.bd.JugadorDAOSQL;
import edu.ucam.pojos.Jugador;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionAddJugador extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("nombre") != null && request.getParameter("apellido") != null && request.getParameter("posicion") != null && request.getParameter("dorsal") != null && request.getParameter("idClub") != null ) {
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String posicion = request.getParameter("posicion");
			int dorsal = Integer.parseInt(request.getParameter("dorsal"));
			int idClub = Integer.parseInt(request.getParameter("idClub"));
			
			getJugadorDAO().insertar(new Jugador(nombre,apellido,posicion,dorsal,idClub));
			
			request.getServletContext().setAttribute("MSGJ", "Jugador Añadido");
		} else {
			request.getServletContext().setAttribute("MSGJ", "Error al añadir al jugador");
		}
		
		request.getServletContext().setAttribute("jugadores", getJugadorDAO().listar());
		
		return "/Control?ID_ACCION=LISTARJUGADORES";
	}

	
	public JugadorDAO getJugadorDAO() throws NamingException {
		return new JugadorDAOSQL();
	}
}
