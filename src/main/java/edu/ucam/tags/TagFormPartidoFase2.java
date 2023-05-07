package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import edu.ucam.pojos.Club;
import edu.ucam.pojos.Liga;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagFormPartidoFase2 extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		@SuppressWarnings("unchecked")
		List<Club> clubs = (List<Club>) pageContext.getServletContext().getAttribute("clubs");
		@SuppressWarnings("unchecked")
		List<Liga> ligas = (List<Liga>) pageContext.getServletContext().getAttribute("ligas");
	
		if(pageContext.getRequest().getParameter("idLiga") != null) {
			try {
				pageContext.getOut().print("<div class=\"form-group mb-4\">");
				pageContext.getOut().print("<label for=\"idLiga\">Liga</label>");
				pageContext.getOut().print("<select class=\"form-select\" name=\"idLiga\" aria-label=\"Liga\">");
				for(Liga liga : ligas) {
					if(liga.getId() == Integer.parseInt(pageContext.getRequest().getParameter("idLiga"))) {
						pageContext.getOut().print("<option selected value="+liga.getId()+">"+liga.getNombre()+"</option>");
					}
				}
				pageContext.getOut().print("</select>");
				pageContext.getOut().print("</div>");
				pageContext.getOut().print("<div class=\"form-group mb-4\">");
				pageContext.getOut().print("<label for=\"idLocal\">Club local</label>");
				pageContext.getOut().print("<select class=\"form-select\" name=\"idLocal\" aria-label=\"Local\" required>");
				for(Club club : clubs) {
					if(club.getId() != 1 && club.getIdLiga() == Integer.parseInt(pageContext.getRequest().getParameter("idLiga"))) {
						pageContext.getOut().print("<option value="+club.getId()+">"+club.getNombre()+"</option>");
					}
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
