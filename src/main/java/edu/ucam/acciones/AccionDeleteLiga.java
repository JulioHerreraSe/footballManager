package edu.ucam.acciones;

import java.util.List;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAO;
import edu.ucam.bd.ClubDAOSQL;
import edu.ucam.bd.LigaDAO;
import edu.ucam.bd.LigaDAOSQL;
import edu.ucam.bd.PartidoDAO;
import edu.ucam.bd.PartidoDAOSQL;
import edu.ucam.pojos.Club;
import edu.ucam.pojos.Liga;
import edu.ucam.pojos.Partido;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionDeleteLiga extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		List<Club> clubs = getClubDAO().listar();
		List<Partido> partidos = getPartidoDAO().listar();
		if(request.getParameter("idLiga") != null) {
			Liga liga = getLigaDAO().buscar(new Liga(Integer.parseInt(request.getParameter("idLiga"))));
			for(Club club: clubs) {
				if(liga.getId() == club.getIdLiga()) {
					club.setIdLiga(1);
					getClubDAO().actualizar(club);
				}
			}
			for(Partido partido: partidos) {
				if(partido.getIdLiga() == liga.getId()) {
					request.setAttribute("eliminarPartidoLiga", partido.getId());
					new AccionDeletePartido().ejecutar(request, response);
				}
			}
			new LigaDAOSQL().eliminar(liga);
			request.getServletContext().setAttribute("MSGL", "Liga eliminada");
		}else {
			request.getServletContext().setAttribute("MSGL", "No se ha podido eliminar la liga");
		}
		
		request.getServletContext().setAttribute("clubs", getClubDAO().listar());
		request.getServletContext().setAttribute("ligas", getLigaDAO().listar());
		request.getServletContext().setAttribute("partidos", getPartidoDAO().listar());
		
		return "/Control?ID_ACCION=LISTARLIGAS";
	}
	
	public ClubDAO getClubDAO() throws NamingException {
		return new ClubDAOSQL();
	}
	
	public LigaDAO getLigaDAO() throws NamingException {
		return new LigaDAOSQL();
	}
	
	public PartidoDAO getPartidoDAO() throws NamingException {
		return new PartidoDAOSQL();
	}

}
