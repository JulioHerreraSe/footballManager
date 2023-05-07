package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.UserDAO;
import edu.ucam.bd.UserDAOSQL;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionListarUser  extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		
		request.getServletContext().setAttribute("users", getUserDAO().listar());
		
		return "users.jsp";
	}
	
	public UserDAO getUserDAO() throws NamingException {
		return new UserDAOSQL();
	}

}
