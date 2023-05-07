package edu.ucam.acciones;

import javax.naming.NamingException;

import edu.ucam.bd.UserDAO;
import edu.ucam.bd.UserDAOSQL;
import edu.ucam.pojos.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccionUpdateUser extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws NamingException {
		if(request.getParameter("idUser") != null && request.getParameter("nombre") != null && request.getParameter("pass") != null) {
			int id = Integer.parseInt(request.getParameter("idUser"));
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("pass");
			
			getUserDAO().actualizar(new User(id,nombre,pass));
			request.getServletContext().setAttribute("user", null);
			request.getServletContext().setAttribute("MSGU", "Usuario Actualizado");
		} else {
			request.getServletContext().setAttribute("MSGU", "No se ha podido actualizar al usuario");
		}
		
		request.getServletContext().setAttribute("users", getUserDAO().listar());
		
		return "/Control?ID_ACCION=LISTARUSERS";
	}
	
	public UserDAO getUserDAO() throws NamingException {
		return new UserDAOSQL();
	}

}
