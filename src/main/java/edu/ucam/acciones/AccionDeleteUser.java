package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.UserDAO;
import edu.ucam.bd.UserDAOSQL;
import edu.ucam.pojos.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionDeleteUser extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("idUser") != null) {
			
			getUserDAO().eliminar(new User(Integer.parseInt(request.getParameter("idUser"))));
			request.getServletContext().setAttribute("MSGU", "Usuario eliminado");
		} else {
			request.getServletContext().setAttribute("MSGU", "No se ha podido eliminar al usuario");
		}
		
		request.getServletContext().setAttribute("users", getUserDAO().listar());
		
		return "/Control?ID_ACCION=LISTARUSERS";
	}

	public UserDAO getUserDAO() throws NamingException {
		return new UserDAOSQL();
	}
	
}
