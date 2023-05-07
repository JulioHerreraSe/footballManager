package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.JugadorDAO;
import edu.ucam.bd.JugadorDAOSQL;
import edu.ucam.pojos.Jugador;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionEditarJugador extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("idJugador") != null) {
			request.getServletContext().setAttribute("jugador", getJugadorDAO().buscar(new Jugador(Integer.parseInt(request.getParameter("idJugador")))));
		} else {
			request.getServletContext().setAttribute("MSGJ", "No se puede editar al jugador");
			return "/Control?ID_ACCION=LISTARJUGADORES";
		}
		return "editarJugador.jsp";
	}

	public JugadorDAO getJugadorDAO() throws NamingException {
		return new JugadorDAOSQL();
	}
	
}
