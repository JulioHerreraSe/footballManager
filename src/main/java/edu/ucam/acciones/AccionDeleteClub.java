package edu.ucam.acciones;

import java.util.List;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAO;
import edu.ucam.bd.ClubDAOSQL;
import edu.ucam.bd.JugadorDAO;
import edu.ucam.bd.JugadorDAOSQL;
import edu.ucam.bd.PartidoDAO;
import edu.ucam.bd.PartidoDAOSQL;
import edu.ucam.pojos.Club;
import edu.ucam.pojos.Jugador;
import edu.ucam.pojos.Partido;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionDeleteClub extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		// Comprobamos que el parametro id no este a nulo
		if(request.getParameter("idClub") != null) {
			// Instanciamos el club solo con el parametro necesario para la eliminacion
			Club club = new Club(Integer.parseInt(request.getParameter("idClub")));
			// Cargamos la lista de jugadores
			
			List<Jugador> jugadores = getJugadorDAO().listar();
			// Cargamos la lista de partidos
			List<Partido> partidos = getPartidoDAO().listar();
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGC", "Club eliminado");
			// Recoremos la lista de jugadores para actulizar los que esten en el club a estado sin club
			for(Jugador jugador: jugadores) {
				// Comprobar si estan en el club
				if(jugador.getIdClub() == club.getId())
				{
					// Poner el jugador en estado sin club 
					jugador.setIdClub(1);
					// Actualizar al jugador en la BD
					getJugadorDAO().actualizar(jugador);
					// Añadimos el mensaje de comunicación con el cliente
					request.getServletContext().setAttribute("MSGC", "Club eliminado y jugadores despedidos");
				}
			}
			for(Partido partido: partidos) {
				// Comprobar si estan en el club
				if(partido.getIdLocal() == club.getId())
				{
					request.setAttribute("eliminarPartidoLiga", partido.getId());
					
					new AccionDeletePartido().ejecutar(request, response);
				}
			}
			partidos = getPartidoDAO().listar();
			for(Partido partido: partidos) {
				// Comprobar si estan en el club
				if(partido.getIdVisitante() == club.getId())
				{
					request.setAttribute("eliminarPartidoLiga", partido.getId());
					new AccionDeletePartido().ejecutar(request, response);
				}
			}
			// Eliminamos el club
			getClubDAO().eliminar(club);
			
			request.setAttribute("partido", null);
		}else {
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGC", "No se ha podido eliminar al club");
		}
		
		request.getServletContext().setAttribute("clubs", getClubDAO().listar());
		
		// Ponemos la ruta a la que redireccionaremos
		return "/Control?ID_ACCION=LISTARCLUBS";
	}
	
	public JugadorDAO getJugadorDAO() throws NamingException {
		return new JugadorDAOSQL();
	}
	
	public ClubDAO getClubDAO() throws NamingException {
		return new ClubDAOSQL();
	}
	
	public PartidoDAO getPartidoDAO() throws NamingException {
		return new PartidoDAOSQL();
	}
	
}
