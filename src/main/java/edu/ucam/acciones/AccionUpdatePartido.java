package edu.ucam.acciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAO;
import edu.ucam.bd.ClubDAOSQL;
import edu.ucam.bd.PartidoDAO;
import edu.ucam.bd.PartidoDAOSQL;
import edu.ucam.pojos.Club;
import edu.ucam.pojos.Partido;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionUpdatePartido extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		// Comprobamos que los parametros no sean nulos
		if(request.getParameter("idPartido") != null && request.getParameter("idLiga") != null && request.getParameter("idLocal") != null && request.getParameter("idVisitante") != null && request.getParameter("fecha") != null && request.getParameter("golesLocal") != null && request.getParameter("golesVisitante") != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date fechaSql = null;
			
			// Recogemos los parametros
			int idPartido = Integer.parseInt(request.getParameter("idPartido"));
			int idLiga = Integer.parseInt(request.getParameter("idLiga"));
			int idLocal = Integer.parseInt(request.getParameter("idLocal"));
			int idVisitante = Integer.parseInt(request.getParameter("idVisitante"));
			int golesLocal = Integer.parseInt(request.getParameter("golesLocal"));
			int golesVisitante = Integer.parseInt(request.getParameter("golesVisitante"));
			try {
			    Date fechaUtil = dateFormat.parse(request.getParameter("fecha"));
			    fechaSql = new java.sql.Date(fechaUtil.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Partido partidoBorrar = getPartidoDAO().buscar(new Partido(idPartido));
			
			getPartidoDAO().actualizar(new Partido(idPartido,idLiga,idLocal,idVisitante,fechaSql,golesLocal,golesVisitante));
			retirarPuntos(partidoBorrar.getGolesLocal(), partidoBorrar.getGolesVisitante(), partidoBorrar.getIdLocal(), partidoBorrar.getIdVisitante());
			seleccionarGanador(golesLocal, golesVisitante, idLocal, idVisitante);
			request.getServletContext().setAttribute("clubs", getClubDAO().listar());
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGP", "partido Actualizado");
		} else {
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSGP", "No se ha podido actualizar el partido");
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
	
	public void seleccionarGanador(int golesLocal, int golesVisitante, int idLocal, int idVisitante) throws NamingException{
		if(golesLocal > golesVisitante) {
			Club clubLocal = getClubDAO().buscar(new Club(idLocal));
			clubLocal.setGolesFavor(golesLocal + clubLocal.getGolesFavor());
			clubLocal.setGolesContra(golesVisitante + clubLocal.getGolesContra());
			clubLocal.setPuntos(3 + clubLocal.getPuntos());
			clubLocal.setPartidosGanados(clubLocal.getPartidosGanados() + 1);
			getClubDAO().actualizar(clubLocal);
			Club clubVisitante = getClubDAO().buscar(new Club(idVisitante));
			clubVisitante.setGolesFavor(golesVisitante + clubVisitante.getGolesFavor());
			clubVisitante.setGolesContra(golesLocal + clubVisitante.getGolesContra());
			clubVisitante.setPartidosPerdidos(clubVisitante.getPartidosPerdidos()+1);
			getClubDAO().actualizar(clubVisitante);
		}else if(golesVisitante > golesLocal) {
			Club clubLocal = getClubDAO().buscar(new Club(idLocal));
			clubLocal.setGolesFavor(golesLocal + clubLocal.getGolesFavor());
			clubLocal.setGolesContra(golesVisitante + clubLocal.getGolesContra());
			clubLocal.setPartidosPerdidos(clubLocal.getPartidosPerdidos() + 1);
			getClubDAO().actualizar(clubLocal);
			Club clubVisitante = getClubDAO().buscar(new Club(idVisitante));
			clubVisitante.setGolesFavor(golesVisitante + clubVisitante.getGolesFavor());
			clubVisitante.setGolesContra(golesLocal + clubVisitante.getGolesContra());
			clubVisitante.setPuntos(clubVisitante.getPuntos()+3);
			clubVisitante.setPartidosGanados(clubVisitante.getPartidosGanados()+1);
			getClubDAO().actualizar(clubVisitante);
		} else {
			Club clubLocal = getClubDAO().buscar(new Club(idLocal));
			clubLocal.setGolesFavor(golesLocal + clubLocal.getGolesFavor());
			clubLocal.setGolesContra(golesVisitante + clubLocal.getGolesContra());
			clubLocal.setPuntos(clubLocal.getPuntos() + 1);
			clubLocal.setPartidosEmpatados(clubLocal.getPartidosEmpatados() + 1);
			getClubDAO().actualizar(clubLocal);
			Club clubVisitante = getClubDAO().buscar(new Club(idVisitante));
			clubVisitante.setGolesFavor(golesVisitante + clubVisitante.getGolesFavor());
			clubVisitante.setGolesContra(golesLocal + clubVisitante.getGolesContra());
			clubVisitante.setPuntos(clubVisitante.getPuntos()+1);
			clubVisitante.setPartidosEmpatados(clubVisitante.getPartidosEmpatados()+1);
			getClubDAO().actualizar(clubVisitante);
		}
	}
	
	public void retirarPuntos(int golesLocal, int golesVisitante, int idLocal, int idVisitante) throws NamingException {
		if(golesLocal > golesVisitante) {
			Club clubLocal = new ClubDAOSQL().buscar(new Club(idLocal));
			clubLocal.setGolesFavor(clubLocal.getGolesFavor() - golesLocal);
			clubLocal.setGolesContra(clubLocal.getGolesContra() - golesVisitante );
			clubLocal.setPuntos(clubLocal.getPuntos() - 3);
			clubLocal.setPartidosGanados(clubLocal.getPartidosGanados() - 1);
			new ClubDAOSQL().actualizar(clubLocal);
			Club clubVisitante = new ClubDAOSQL().buscar(new Club(idVisitante));
			clubVisitante.setGolesFavor(clubVisitante.getGolesFavor() - golesVisitante);
			clubVisitante.setGolesContra(clubVisitante.getGolesContra() - golesLocal);
			clubVisitante.setPartidosPerdidos(clubVisitante.getPartidosPerdidos() - 1);
			new ClubDAOSQL().actualizar(clubVisitante);
		}else if(golesVisitante > golesLocal) {
			Club clubLocal = new ClubDAOSQL().buscar(new Club(idLocal));
			clubLocal.setGolesFavor(clubLocal.getGolesFavor() - golesLocal);
			clubLocal.setGolesContra(clubLocal.getGolesContra() - golesVisitante);
			clubLocal.setPartidosPerdidos(clubLocal.getPartidosPerdidos() - 1);
			new ClubDAOSQL().actualizar(clubLocal);
			Club clubVisitante = new ClubDAOSQL().buscar(new Club(idVisitante));
			clubVisitante.setGolesFavor(clubVisitante.getGolesFavor() - golesVisitante);
			clubVisitante.setGolesContra(clubVisitante.getGolesContra() - golesLocal);
			clubVisitante.setPuntos(clubVisitante.getPuntos() - 3);
			clubVisitante.setPartidosGanados(clubVisitante.getPartidosGanados() - 1);
			new ClubDAOSQL().actualizar(clubVisitante);
		} else if(golesVisitante == golesLocal) {
			Club clubLocal = new ClubDAOSQL().buscar(new Club(idLocal));
			clubLocal.setGolesFavor(clubLocal.getGolesFavor() - golesLocal);
			clubLocal.setGolesContra(clubLocal.getGolesContra() - golesVisitante);
			clubLocal.setPuntos(clubLocal.getPuntos() - 1);
			clubLocal.setPartidosEmpatados(clubLocal.getPartidosEmpatados() - 1);
			new ClubDAOSQL().actualizar(clubLocal);
			Club clubVisitante = new ClubDAOSQL().buscar(new Club(idVisitante));
			clubVisitante.setGolesFavor(clubVisitante.getGolesFavor() - golesVisitante);
			clubVisitante.setGolesContra(clubVisitante.getGolesContra() - golesLocal);
			clubVisitante.setPuntos(clubVisitante.getPuntos() - 1);
			clubVisitante.setPartidosEmpatados(clubVisitante.getPartidosEmpatados() - 1);
			new ClubDAOSQL().actualizar(clubVisitante);
		}
	}

}
