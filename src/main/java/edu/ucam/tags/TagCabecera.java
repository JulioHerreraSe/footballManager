package edu.ucam.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagCabecera extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		if(pageContext.getSession().getAttribute("user").equals("admin")) {
			try {
				pageContext.getOut().print("<li class=\"nav-item\">");
				pageContext.getOut().print("<a class=\"nav-link\" href=\"Control?ID_ACCION=LISTARUSERS\">Usuarios</a>");
				pageContext.getOut().print("</li>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EVAL_BODY_INCLUDE;
	}

}