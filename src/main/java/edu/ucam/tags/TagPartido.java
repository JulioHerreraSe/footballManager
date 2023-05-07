package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import edu.ucam.pojos.Club;
import edu.ucam.pojos.Liga;
import edu.ucam.pojos.Partido;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagPartido extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		@SuppressWarnings("unchecked")
		List<Partido> partidos = (List<Partido>) pageContext.getServletContext().getAttribute("partidos");
		@SuppressWarnings("unchecked")
		List<Club> clubs = (List<Club>) pageContext.getServletContext().getAttribute("clubs");
		@SuppressWarnings("unchecked")
		List<Liga> ligas = (List<Liga>) pageContext.getServletContext().getAttribute("ligas");
		for(Partido partido: partidos) {
			try {
				pageContext.getOut().print("<tr>");
				for(Liga liga: ligas) {
					if(partido.getIdLiga()==liga.getId()) {
						pageContext.getOut().print("<td>"+liga.getNombre()+"</td>");
					}
				}
				for(Club club: clubs) {
					if(partido.getIdLocal()==club.getId()) {
						pageContext.getOut().print("<td>"+club.getNombre()+"</td>");
					}
				}
				for(Club club: clubs) {
					if(partido.getIdVisitante()==club.getId()) {
						pageContext.getOut().print("<td>"+club.getNombre()+"</td>");
					}
				}
				pageContext.getOut().print("<td>"+partido.getFecha()+"</td>");
				pageContext.getOut().print("<td>"+partido.getGolesLocal()+"</td>");
				pageContext.getOut().print("<td>"+partido.getGolesVisitante()+"</td>");
				pageContext.getOut().print("<td class='text-center'><a href='Control?ID_ACCION=EDITARPARTIDO&idPartido="+partido.getId()+"'><button class='btn btn-outline-primary btn-sm'>EDITAR</button></a></td>");
				pageContext.getOut().print("<td class='text-center'><a href='Control?ID_ACCION=DELETEPARTIDO&idPartido="+partido.getId()+"'><button class='btn btn-outline-danger btn-sm'>BORRAR</button></a></td>");
	        	pageContext.getOut().print("</tr>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EVAL_BODY_INCLUDE;
	}

	
}
