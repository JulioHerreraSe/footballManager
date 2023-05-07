package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import edu.ucam.pojos.Club;
import edu.ucam.pojos.Liga;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagFormPartidoFase1 extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		
		@SuppressWarnings("unchecked")
		List<Liga> ligas = (List<Liga>) pageContext.getServletContext().getAttribute("ligas");
		@SuppressWarnings("unchecked")
		List<Club> clubs = (List<Club>) pageContext.getServletContext().getAttribute("clubs");
		int cantidad = 0;
		boolean sinClubs = true;
		if(pageContext.getRequest().getParameter("idLiga") == null) {
			try {
				pageContext.getOut().print("<div class=\"form-group mb-4\">");
				pageContext.getOut().print("<label for=\"idLiga\">Liga</label>");
				pageContext.getOut().print("<select class=\"form-select\" name=\"idLiga\" aria-label=\"Liga\" required>");
				for(Liga liga : ligas) {
					if(liga.getId() != 1) {
						for(Club club: clubs) {
							if(liga.getId() == club.getIdLiga()) {
								cantidad++;
								sinClubs = false;
							}
						}
						if(cantidad >= 2) {
							pageContext.getOut().print("<option value="+liga.getId()+">"+liga.getNombre()+"</option>");
							cantidad = 0;
						}
					}
				}
				if (sinClubs) {
					pageContext.getOut().print("<option disabled>No hay ligas disponibles</option>");
				}
				pageContext.getOut().print("</select>");
				pageContext.getOut().print("</div>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EVAL_BODY_INCLUDE;
	}
	
}
