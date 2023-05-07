package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import edu.ucam.pojos.Club;
import edu.ucam.pojos.Jugador;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagJugador extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		@SuppressWarnings("unchecked")
		List<Jugador> jugadores = (List<Jugador>) pageContext.getServletContext().getAttribute("jugadores");
		@SuppressWarnings("unchecked")
		List<Club> clubs = (List<Club>) pageContext.getServletContext().getAttribute("clubs");
		for(Jugador jugador: jugadores) {
			try {
				pageContext.getOut().print("<tr>");
				pageContext.getOut().print("<td>"+jugador.getNombre()+"</td>");
				pageContext.getOut().print("<td>"+jugador.getApellido()+"</td>");
				pageContext.getOut().print("<td>"+jugador.getPosicion()+"</td>");
				pageContext.getOut().print("<td>"+jugador.getDorsal()+"</td>");
				for(Club club: clubs) {
					if(jugador.getIdClub()==club.getId()) {
						pageContext.getOut().print("<td>"+club.getNombre()+"</td>");
					}
				}
				pageContext.getOut().print("<td class='text-center'><a href='Control?ID_ACCION=EDITARJUGADOR&idJugador="+jugador.getId()+"'><button class='btn btn-outline-primary btn-sm'>EDITAR</button></a></td>");
				pageContext.getOut().print("<td class='text-center'><a href='Control?ID_ACCION=DELETEJUGADOR&idJugador="+jugador.getId()+"'><button class='btn btn-outline-danger btn-sm'>BORRAR</button></a></td>");
	        	pageContext.getOut().print("</tr>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EVAL_BODY_INCLUDE;
	}

	
}
