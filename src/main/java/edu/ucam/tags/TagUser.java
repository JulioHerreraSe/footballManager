package edu.ucam.tags;

import java.io.IOException;
import java.util.List;

import edu.ucam.pojos.User;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagUser extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) pageContext.getServletContext().getAttribute("users");
		for(User user: users) {
			try {
				pageContext.getOut().print("<tr>");
				pageContext.getOut().print("<td>"+user.getName()+"</td>");
				pageContext.getOut().print("<td>"+user.getPass()+"</td>");
				pageContext.getOut().print("<td class='text-center'><a href='Control?ID_ACCION=EDITARUSER&idUser="+user.getId()+"'><button class='btn btn-outline-primary btn-sm'>EDITAR</button></a></td>");
				pageContext.getOut().print("<td class='text-center'><a href='Control?ID_ACCION=DELETEUSER&idUser="+user.getId()+"'><button class='btn btn-outline-danger btn-sm'>BORRAR</button></a></td>");
				pageContext.getOut().print("</tr>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EVAL_BODY_INCLUDE;
	}

}