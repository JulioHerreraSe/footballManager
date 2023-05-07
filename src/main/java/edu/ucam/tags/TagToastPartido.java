package edu.ucam.tags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagToastPartido extends TagSupport {
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		if(pageContext.getServletContext().getAttribute("MSGP") != null) {
			try {
				pageContext.getOut().print("<script>$(document).ready(function(){$('#liveToast').toast('show');});</script>");
				pageContext.getOut().print("<div class=\"position-fixed bottom-0 end-0 p-3\" style=\"z-index: 11\">");
				pageContext.getOut().print("<div id=\"liveToast\" class=\"toast text-white bg-dark\" role=\"alert\" aria-live=\"assertive\" aria-atomic=\"true\">");
				pageContext.getOut().print("<div class=\"toast-header\">");
				pageContext.getOut().print(" <strong class=\"me-auto\" style=\"color: black\"><i class=\"fa-solid fa-circle-info\"></i> INFORMACIÓN</strong>");
				pageContext.getOut().print("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"toast\" aria-label=\"Close\"></button>");
				pageContext.getOut().print("</div>");
				pageContext.getOut().print("<div class=\"toast-body\">");
				pageContext.getOut().print("<p>"+pageContext.getServletContext().getAttribute("MSGP")+"</p>");
				pageContext.getOut().print("</div>");
				pageContext.getOut().print("</div>");
				pageContext.getOut().print("</div>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			pageContext.getServletContext().setAttribute("MSGP", null);
		}
		return EVAL_BODY_INCLUDE;
	}
}
