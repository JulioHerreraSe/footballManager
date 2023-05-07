package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAO;
import edu.ucam.bd.ClubDAOSQL;
import edu.ucam.bd.PartidoDAO;
import edu.ucam.bd.PartidoDAOSQL;
import edu.ucam.pojos.Club;
import edu.ucam.pojos.Partido;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionDeletePartido extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		
		if(request.getParameter("idPartido") != null) {
			
			Partido partido = getPartidoDAO().buscar( new Partido(Integer.parseInt(request.getParameter("idPartido"))));
			RetirarPuntos(partido.getGolesLocal(), partido.getGolesVisitante(), partido.getIdLocal(), partido.getIdVisitante());
			getPartidoDAO().eliminar(partido);
			request.getServletContext().setAttribute("MSGP", "Partido eliminado");
		} else {
			request.getServletContext().setAttribute("MSGP", "No se ha podido eliminar el Partido");
		}
		
		if(request.getAttribute("eliminarPartidoLiga") != null) {
			Partido partido = getPartidoDAO().buscar(new Partido((int)request.getAttribute("eliminarPartidoLiga")));
			RetirarPuntos(partido.getGolesLocal(), partido.getGolesVisitante(), partido.getIdLocal(), partido.getIdVisitante());
			getPartidoDAO().eliminar(partido);
		}
		request.getServletContext().setAttribute("clubs", getClubDAO().listar());
		request.getServletContext().setAttribute("partidos", getPartidoDAO().listar());
		
		// Ponemos la ruta a la que redireccionaremos
		return "/Control?ID_ACCION=LISTARPARTIDOS";
	}
	
	public ClubDAO getClubDAO() throws NamingException {
		return new ClubDAOSQL();
	}
	
	public PartidoDAO getPartidoDAO() throws NamingException {
		return new PartidoDAOSQL();
	}

	public int RetirarPuntos(int golesLocal, int golesVisitante, int idLocal, int idVisitante) throws NamingException {
		if(golesLocal > golesVisitante) {
			Club clubLocal = getClubDAO().buscar(new Club(idLocal));
			clubLocal.setGolesFavor(clubLocal.getGolesFavor() - golesLocal);
			clubLocal.setGolesContra(clubLocal.getGolesContra() - golesVisitante );
			clubLocal.setPuntos(clubLocal.getPuntos() - 3);
			clubLocal.setPartidosGanados(clubLocal.getPartidosGanados() - 1);
			getClubDAO().actualizar(clubLocal);
			Club clubVisitante = getClubDAO().buscar(new Club(idVisitante));
			clubVisitante.setGolesFavor(clubVisitante.getGolesFavor() - golesVisitante);
			clubVisitante.setGolesContra(clubVisitante.getGolesContra() - golesLocal);
			clubVisitante.setPartidosPerdidos(clubVisitante.getPartidosPerdidos() - 1);
			getClubDAO().actualizar(clubVisitante);
			return 1;
		}else if(golesVisitante > golesLocal) {
			Club clubLocal = getClubDAO().buscar(new Club(idLocal));
			clubLocal.setGolesFavor(clubLocal.getGolesFavor() - golesLocal);
			clubLocal.setGolesContra(clubLocal.getGolesContra() - golesVisitante);
			clubLocal.setPartidosPerdidos(clubLocal.getPartidosPerdidos() - 1);
			getClubDAO().actualizar(clubLocal);
			Club clubVisitante = getClubDAO().buscar(new Club(idVisitante));
			clubVisitante.setGolesFavor(clubVisitante.getGolesFavor() - golesVisitante);
			clubVisitante.setGolesContra(clubVisitante.getGolesContra() - golesLocal);
			clubVisitante.setPuntos(clubVisitante.getPuntos() - 3);
			clubVisitante.setPartidosGanados(clubVisitante.getPartidosGanados() - 1);
			getClubDAO().actualizar(clubVisitante);
			return 1;
		} else if(golesVisitante == golesLocal) {
			Club clubLocal = getClubDAO().buscar(new Club(idLocal));
			clubLocal.setGolesFavor(clubLocal.getGolesFavor() - golesLocal);
			clubLocal.setGolesContra(clubLocal.getGolesContra() - golesVisitante);
			clubLocal.setPuntos(clubLocal.getPuntos() - 1);
			clubLocal.setPartidosEmpatados(clubLocal.getPartidosEmpatados() - 1);
			getClubDAO().actualizar(clubLocal);
			Club clubVisitante = getClubDAO().buscar(new Club(idVisitante));
			clubVisitante.setGolesFavor(clubVisitante.getGolesFavor() - golesVisitante);
			clubVisitante.setGolesContra(clubVisitante.getGolesContra() - golesLocal);
			clubVisitante.setPuntos(clubVisitante.getPuntos() - 1);
			clubVisitante.setPartidosEmpatados(clubVisitante.getPartidosEmpatados() - 1);
			getClubDAO().actualizar(clubVisitante);
			return 1;
		}
		return 1;
	}
	
}
