package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;

import edu.ucam.bd.PartidoDAOSQL;
import edu.ucam.pojos.Club;
import edu.ucam.pojos.Liga;
import edu.ucam.pojos.Partido;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagEditarPartido extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		
		@SuppressWarnings("unchecked")
		List<Club> clubs = (List<Club>) pageContext.getServletContext().getAttribute("clubs");
		@SuppressWarnings("unchecked")
		List<Liga> ligas = (List<Liga>) pageContext.getServletContext().getAttribute("ligas");
		
		if(pageContext.getRequest().getParameter("idPartido") != null) {
			Partido partido = null;
			try {
				partido = new PartidoDAOSQL().buscar(new Partido(Integer.parseInt((pageContext.getRequest().getParameter("idPartido")))));
			} catch (NumberFormatException | NamingException e1) {
				e1.printStackTrace();
			}
			try {
				pageContext.getOut().print("<div class=\"form-group mb-4\">");
				pageContext.getOut().print("<label for=\"idLiga\">Liga</label>");
				pageContext.getOut().print("<select class=\"form-select\" name=\"idLiga\" aria-label=\"Liga\">");
				for(Liga liga : ligas) {
					if(liga.getId() == partido.getIdLiga()) {
						pageContext.getOut().print("<option selected value="+liga.getId()+">"+liga.getNombre()+"</option>");
					}
				}
				pageContext.getOut().print("</select>");
				pageContext.getOut().print("</div>");
				pageContext.getOut().print("<div class=\"form-group mb-4\">");
				pageContext.getOut().print("<label for=\"idLocal\">Club local</label>");
				pageContext.getOut().print("<select class=\"form-select\" name=\"idLocal\" aria-label=\"Local\">");
				for(Club club : clubs) {
					if(club.getId() == partido.getIdLocal()) {
						pageContext.getOut().print("<option selected value="+club.getId()+">"+club.getNombre()+"</option>");
					}
				}
				pageContext.getOut().print("</select>");
				pageContext.getOut().print("</div>");
				pageContext.getOut().print("<div class=\"form-group mb-4\">");
				pageContext.getOut().print("<label for=\"idVisitante\">Club visitante</label>");
				pageContext.getOut().print("<select class=\"form-select\" name=\"idVisitante\" aria-label=\"visitante\">");
				for(Club club : clubs) {
					if(club.getId() == partido.getIdVisitante()) {
						pageContext.getOut().print("<option selected value="+club.getId()+">"+club.getNombre()+"</option>");
					}
				}
				pageContext.getOut().print("</select>");
				pageContext.getOut().print("</div>");
				pageContext.getOut().print("<div class=\"form-group mb-4\">");
				pageContext.getOut().print("<label for=\"fecha\">Fecha</label>");
				pageContext.getOut().print("<input name=\"fecha\" type=\"date\" class=\"form-control\" value=\""+partido.getFecha()+"\" required>");
				pageContext.getOut().print("</div>");
				pageContext.getOut().print("<div class=\"form-group mb-4\">");
				pageContext.getOut().print("<label for=\"golesLocal\">Goles equipo local</label>");
				pageContext.getOut().print("<input name=\"golesLocal\" type=\"number\" min=\"0\" pattern=\"^[0-9]+\" class=\"form-control\" value=\""+partido.getGolesLocal()+"\" required>");
				pageContext.getOut().print("</div>");
				pageContext.getOut().print("<div class=\"form-group mb-4\">");
				pageContext.getOut().print("<label for=\"golesVisitante\">Goles equipo visitante</label>");
				pageContext.getOut().print("<input name=\"golesVisitante\" type=\"number\" min=\"0\" pattern=\"^[0-9]+\" class=\"form-control\" value=\""+partido.getGolesVisitante()+"\" required>");
				pageContext.getOut().print("</div>");
				pageContext.getOut().print("<input type=\"hidden\" name=\"idPartido\" value=\""+partido.getId()+"\"");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EVAL_BODY_INCLUDE;
	}
	
}