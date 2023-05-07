package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import edu.ucam.pojos.Club;
import edu.ucam.pojos.Liga;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagSelectLiga extends TagSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		@SuppressWarnings("unchecked")
		List<Liga> ligas = (List<Liga>) pageContext.getServletContext().getAttribute("ligas");
		
		if(pageContext.getServletContext().getAttribute("club") != null) {
			Club club = (Club)pageContext.getServletContext().getAttribute("club");
			for(Liga liga: ligas) {
				try {
					if(liga.getId() == club.getIdLiga()) {
						pageContext.getOut().print("<option selected value='"+liga.getId()+"'>"+liga.getNombre()+"</option>");
					} else {
						pageContext.getOut().print("<option value='"+liga.getId()+"'>"+liga.getNombre()+"</option>");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if(pageContext.getRequest().getParameter("idLiga") != null){
			if(Integer.parseInt(pageContext.getRequest().getParameter("idLiga")) == 0) {
				try {
					pageContext.getOut().print("<option value='0'>Debes selecionar una liga</option>");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			for(Liga liga: ligas) {
				try {
					if(liga.getId() == Integer.parseInt(pageContext.getRequest().getParameter("idLiga"))) {
						pageContext.getOut().print("<option selected value='"+liga.getId()+"'>"+liga.getNombre()+"</option>");
					} else if(liga.getId() != 1) {
						pageContext.getOut().print("<option value='"+liga.getId()+"'>"+liga.getNombre()+"</option>");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			for(Liga liga: ligas) {
				try {
						pageContext.getOut().print("<option value='"+liga.getId()+"'>"+liga.getNombre()+"</option>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return EVAL_BODY_INCLUDE;
	}
}
