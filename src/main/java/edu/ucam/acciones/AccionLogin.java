package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.UserDAO;
import edu.ucam.bd.UserDAOSQL;
import edu.ucam.pojos.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionLogin extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		// Comprobamos si el usuario y contraseña son correctos 
		if(getUserDAO().Validar(new User(request.getParameter("nameLogin"),request.getParameter("pass"))) == 1){
			// Añadimos el mensaje de comunicación con el cliente
			request.getServletContext().setAttribute("MSG_ERROR", "");
			// Cargamos al usuario en la sesion
			request.getSession().setAttribute("user", request.getParameter("nameLogin"));
			// Ponemos la ruta a la que redireccionaremos
			return "inicio.jsp";
		}
		// Añadimos el mensaje de comunicación con el cliente
		request.getServletContext().setAttribute("MSG_ERROR", "Nombre de usuario o contraseña incorrectos");
		// Ponemos la ruta a la que redireccionaremos
		return "index.jsp";
		
	}
	
	public UserDAO getUserDAO() throws NamingException {
		return new UserDAOSQL();
	}

}
