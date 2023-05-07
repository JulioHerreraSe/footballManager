package edu.ucam.tags;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import edu.ucam.pojos.Club;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagClasificaciones extends TagSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		int posicion = 1;
		// Cragamos la lsita de clubs ligas
		@SuppressWarnings("unchecked")
		List<Club> clubs = (List<Club>) pageContext.getServletContext().getAttribute("clubs");
		clubs.sort(Comparator.comparing(Club::getPuntos).reversed()
	             .thenComparing(Club::getGolesFavor, Comparator.reverseOrder()));
		if(pageContext.getRequest().getParameter("idLiga") != null) {
			// Recorremos la lista de clubs
			for(Club club: clubs) {
				// Saltamos el id 1 puesto que eso significa que no tiene club un jugador
				if(club.getId()!=1 && club.getIdLiga() == Integer.parseInt(pageContext.getRequest().getParameter("idLiga"))) {
					imrpimirTabla(club, posicion);
					posicion++;
				}
			}
		}else {
			// Recorremos la lista de clubs
			for(Club club: clubs) {
				// Saltamos el id 1 puesto que eso significa que no tiene club un jugador
				if(club.getId()!=1) {
					imrpimirTabla(club, posicion);
					posicion++;
				}
			}
		}
		
		
		return EVAL_BODY_INCLUDE;
	}

	public void imrpimirTabla(Club club, int posicion) {
		try {
			// Imprimimos el html y datos necesarios de la pagina
			pageContext.getOut().print("<tr>");
			pageContext.getOut().print("<td>"+posicion+"</td>");
			pageContext.getOut().print("<td>"+club.getNombre()+"</td>");
			pageContext.getOut().print("<td>"+club.getPuntos()+"</td>");
			pageContext.getOut().print("<td>"+club.getPartidosGanados()+"</td>");
			pageContext.getOut().print("<td>"+club.getPartidosEmpatados()+"</td>");
			pageContext.getOut().print("<td>"+club.getPartidosPerdidos()+"</td>");
			pageContext.getOut().print("<td>"+club.getGolesFavor()+"</td>");
			pageContext.getOut().print("<td>"+club.getGolesContra()+"</td>");
			pageContext.getOut().print("</tr>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
