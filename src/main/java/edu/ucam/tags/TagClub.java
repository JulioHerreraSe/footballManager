package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import edu.ucam.pojos.Club;
import edu.ucam.pojos.Jugador;
import edu.ucam.pojos.Liga;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagClub extends TagSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		// Cragamos la lsita de clubs, jugadores y ligas
		@SuppressWarnings("unchecked")
		List<Club> clubs = (List<Club>) pageContext.getServletContext().getAttribute("clubs");
		@SuppressWarnings("unchecked")
		List<Jugador> jugadores = (List<Jugador>) pageContext.getServletContext().getAttribute("jugadores");
		@SuppressWarnings("unchecked")
		List<Liga> ligas = (List<Liga>) pageContext.getServletContext().getAttribute("ligas");
		// Recorremos la lista de clubs
		for(Club club: clubs) {
			// Saltamos el id 1 puesto que eeso significa que no tiene club un jugador
			if(club.getId()!=1) {
				try {
					// Imprimimos el html, css y datos necesarios de la pagina
					pageContext.getOut().print("<tr>");
					pageContext.getOut().print("<td>"+club.getNombre()+"</td>");
					// Recoremos la lista de ligas para poner el nombre en lugar del id
					for(Liga liga: ligas) {
						if(liga.getId()==club.getIdLiga()) {
							pageContext.getOut().print("<td>"+liga.getNombre()+"</td>");
						}
					}
					pageContext.getOut().print("<td>");
					pageContext.getOut().print("<ul class=\"list-group-flush\">");
					// Recoremos la lista de jugadores para mostrar los que pertenecen al culb
					for(Jugador jugador: jugadores) {
						if(jugador.getIdClub()==club.getId()) {
							pageContext.getOut().print("<li class=\"list-group-item\">"+jugador.getNombre()+" "+jugador.getApellido()+"<a href='Control?ID_ACCION=DELETEJUGADORCLUB&idJugador="+jugador.getId()+"'><button class=\"btn btn-outline-danger btn-sm float-end\">Despedir</button></a></li>");
						}
					}
					pageContext.getOut().print("</ul>");
					pageContext.getOut().print("</td>");
					pageContext.getOut().print("<td class='text-center'><a href='Control?ID_ACCION=EDITARCLUB&idClub="+club.getId()+"'><button class='btn btn-outline-primary btn-sm'>EDITAR</button></a></td>");
					pageContext.getOut().print("<td class='text-center'><a href='Control?ID_ACCION=DELETECLUB&idClub="+club.getId()+"'><button class='btn btn-outline-danger btn-sm'>BORRAR</button></a></td>");
		        	pageContext.getOut().print("</tr>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return EVAL_BODY_INCLUDE;
	}

	
}
