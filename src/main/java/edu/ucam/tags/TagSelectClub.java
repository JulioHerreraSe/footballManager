package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import edu.ucam.pojos.Club;
import edu.ucam.pojos.Jugador;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagSelectClub extends TagSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		@SuppressWarnings("unchecked")
		List<Club> clubs = (List<Club>) pageContext.getServletContext().getAttribute("clubs");
		if(pageContext.getServletContext().getAttribute("jugador") != null) {
			Jugador jugador =(Jugador)pageContext.getServletContext().getAttribute("jugador");
			int idClub = jugador.getIdClub();
				for(Club club: clubs) {
					if(idClub == club.getId()) {
						try {
							pageContext.getOut().print("<option selected value='"+club.getId()+"'>"+club.getNombre()+"</option>");
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						try {
							pageContext.getOut().print("<option value='"+club.getId()+"'>"+club.getNombre()+"</option>");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
		} else {
			for(Club club: clubs) {
				try {
					if(club.getId()!=1)
						pageContext.getOut().print("<option value='"+club.getId()+"'>"+club.getNombre()+"</option>");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return EVAL_BODY_INCLUDE;
	}
}
