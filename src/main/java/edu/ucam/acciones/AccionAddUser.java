package edu.ucam.acciones;

import java.util.List;

import javax.naming.NamingException;

import edu.ucam.bd.UserDAO;
import edu.ucam.bd.UserDAOSQL;
import edu.ucam.pojos.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionAddUser extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) request.getServletContext().getAttribute("users");
		if(request.getParameter("name") != null && request.getParameter("pass") != null) {
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			for(User user: users) {
				if(name.equals(user.getName())) {
					request.getServletContext().setAttribute("MSGU", "Ya existe el usuario");
					return "/Control?ID_ACCION=LISTARUSERS";
				}
			}
			getUserDAO().insertar(new User(name,pass));
			
			request.getServletContext().setAttribute("MSGU", "Usuario Añadido");
		} else {
			request.getServletContext().setAttribute("MSGU", "Error al añadir al usuario");
		}
		
		request.getServletContext().setAttribute("users", getUserDAO().listar());
		
		return "/Control?ID_ACCION=LISTARUSERS";
	}
	
	public UserDAO getUserDAO() throws NamingException {
		return new UserDAOSQL();
	}

}
