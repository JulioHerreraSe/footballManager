package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import edu.ucam.pojos.Club;
import edu.ucam.pojos.Liga;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagLiga extends TagSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		@SuppressWarnings("unchecked")
		List<Liga> ligas = (List<Liga>) pageContext.getServletContext().getAttribute("ligas");
		@SuppressWarnings("unchecked")
		List<Club> clubs = (List<Club>) pageContext.getServletContext().getAttribute("clubs");
		for(Liga liga: ligas) {
			if(liga.getId() != 1) {
				try {
					pageContext.getOut().print("<tr>");
					pageContext.getOut().print("<td>"+liga.getNombre()+"</td>");
					pageContext.getOut().print("<td>");
					pageContext.getOut().print("<ul class=\"list-group-flush\">");
					for(Club club: clubs) {
						if(liga.getId()==club.getIdLiga()) {
							pageContext.getOut().print("<li class=\"list-group-item\">"+club.getNombre()+"</li>");
						}
					}
					pageContext.getOut().print("</ul>");
					pageContext.getOut().print("</td>");
					pageContext.getOut().print("<td class='text-center'><a href='Control?ID_ACCION=EDITARLIGA&idLiga="+liga.getId()+"'><button class='btn btn-outline-primary btn-sm'>EDITAR</button></a></td>");
					pageContext.getOut().print("<td class='text-center'><a href='Control?ID_ACCION=DELETELIGA&idLiga="+liga.getId()+"'><button class='btn btn-outline-danger btn-sm'>BORRAR</button></a></td>");
		        	pageContext.getOut().print("</tr>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return EVAL_BODY_INCLUDE;
	}

	
}
