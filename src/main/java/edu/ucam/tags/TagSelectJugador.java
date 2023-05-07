package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import edu.ucam.pojos.Jugador;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagSelectJugador extends TagSupport {
	private static final long serialVersionUID = 1L;
	boolean noHayJugadoresDisponibles = true;
	@Override
	public int doStartTag() throws JspException {
		@SuppressWarnings("unchecked")
		List<Jugador> jugadores = (List<Jugador>) pageContext.getServletContext().getAttribute("jugadores");
		for(Jugador jugador: jugadores) {
			if(jugador.getIdClub() == 1) {
				try {
					pageContext.getOut().print("<option value='"+jugador.getId()+"'>"+jugador.getNombre()+" "+jugador.getApellido()+"</option>");
					noHayJugadoresDisponibles = false;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(noHayJugadoresDisponibles) {
			try {
				pageContext.getOut().print("<option disabled>No hay jugadores disponibles</option>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return EVAL_BODY_INCLUDE;
	}
}
