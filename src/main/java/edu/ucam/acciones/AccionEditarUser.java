package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.UserDAO;
import edu.ucam.bd.UserDAOSQL;
import edu.ucam.pojos.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionEditarUser extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("idUser") != null) {
			request.getServletContext().setAttribute("user", getUserDAO().buscar(new User(Integer.parseInt(request.getParameter("idUser")))));
		} else {
			request.getServletContext().setAttribute("MSGU", "No se puede editar al usuario");
			return "/Control?ID_ACCION=LISTARUSER";
		}
		return "editarUser.jsp";
	}
	
	public UserDAO getUserDAO() throws NamingException {
		return new UserDAOSQL();
	}

}
