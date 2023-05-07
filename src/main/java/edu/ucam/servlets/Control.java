package edu.ucam.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Hashtable;

import javax.naming.NamingException;

import edu.ucam.acciones.Accion;
import edu.ucam.acciones.AccionAddClub;
import edu.ucam.acciones.AccionAddJugador;
import edu.ucam.acciones.AccionAddJugadorClub;
import edu.ucam.acciones.AccionAddLiga;
import edu.ucam.acciones.AccionAddPartido;
import edu.ucam.acciones.AccionAddUser;
import edu.ucam.acciones.AccionClasificaciones;
import edu.ucam.acciones.AccionDeleteClub;
import edu.ucam.acciones.AccionDeleteJugador;
import edu.ucam.acciones.AccionDeleteJugadorClub;
import edu.ucam.acciones.AccionDeleteLiga;
import edu.ucam.acciones.AccionDeletePartido;
import edu.ucam.acciones.AccionDeleteUser;
import edu.ucam.acciones.AccionEditarClub;
import edu.ucam.acciones.AccionEditarJugador;
import edu.ucam.acciones.AccionEditarLiga;
import edu.ucam.acciones.AccionEditarPartido;
import edu.ucam.acciones.AccionEditarUser;
import edu.ucam.acciones.AccionInsertarPartidoFase1;
import edu.ucam.acciones.AccionInsertarPartidoFase2;
import edu.ucam.acciones.AccionInsertarPartidoFase3;
import edu.ucam.acciones.AccionInsertarPartidoFase4;
import edu.ucam.acciones.AccionListarClubs;
import edu.ucam.acciones.AccionListarJugadores;
import edu.ucam.acciones.AccionListarLigas;
import edu.ucam.acciones.AccionListarPartido;
import edu.ucam.acciones.AccionListarUser;
import edu.ucam.acciones.AccionLogin;
import edu.ucam.acciones.AccionLogout;
import edu.ucam.acciones.AccionUpdateClub;
import edu.ucam.acciones.AccionUpdateJugador;
import edu.ucam.acciones.AccionUpdateLiga;
import edu.ucam.acciones.AccionUpdatePartido;
import edu.ucam.acciones.AccionUpdateUser;

public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Hashtable de acciones
	private Hashtable<String, Accion> acciones;
       
    public Control() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	// Iniciamos la tabla de acciones con sus acciones corespondientes
    	if(acciones == null) {
    		acciones = new Hashtable<String,Accion>();
    		acciones.put("LOGIN", new AccionLogin());
    		acciones.put("LOGOUT", new AccionLogout());
    		acciones.put("LISTARUSERS", new AccionListarUser());
    		acciones.put("LISTARCLUBS", new AccionListarClubs());
    		acciones.put("LISTARLIGAS", new AccionListarLigas());
    		acciones.put("LISTARJUGADORES", new AccionListarJugadores());
    		acciones.put("LISTARPARTIDOS", new AccionListarPartido());
    		acciones.put("ADDJUGADORCLUB", new AccionAddJugadorClub());
    		acciones.put("DELETEJUGADORCLUB", new AccionDeleteJugadorClub());
    		acciones.put("ADDJUGADOR", new AccionAddJugador());
    		acciones.put("ADDCLUB", new AccionAddClub());
    		acciones.put("ADDLIGA", new AccionAddLiga());
    		acciones.put("ADDPARTIDO", new AccionAddPartido());
    		acciones.put("ADDUSER", new AccionAddUser());
    		acciones.put("EDITARJUGADOR", new AccionEditarJugador());
    		acciones.put("EDITARCLUB", new AccionEditarClub());
    		acciones.put("EDITARLIGA", new AccionEditarLiga());
    		acciones.put("EDITARUSER", new AccionEditarUser());
    		acciones.put("EDITARPARTIDO", new AccionEditarPartido());
    		acciones.put("UPDATEJUGADOR", new AccionUpdateJugador());
    		acciones.put("UPDATECLUB", new AccionUpdateClub());
    		acciones.put("UPDATELIGA", new AccionUpdateLiga());
    		acciones.put("UPDATEPARTIDO", new AccionUpdatePartido());
    		acciones.put("UPDATEUSER", new AccionUpdateUser());
    		acciones.put("DELETEJUGADOR", new AccionDeleteJugador());
    		acciones.put("DELETECLUB", new AccionDeleteClub());
    		acciones.put("DELETELIGA", new AccionDeleteLiga());
    		acciones.put("DELETEPARTIDO", new AccionDeletePartido());
    		acciones.put("DELETEUSER", new AccionDeleteUser());
    		acciones.put("INSERTARPARTIDO", new AccionInsertarPartidoFase1());
    		acciones.put("INSERTARPARTIDOFASE2", new AccionInsertarPartidoFase2());
    		acciones.put("INSERTARPARTIDOFASE3", new AccionInsertarPartidoFase3());
    		acciones.put("INSERTARPARTIDOFASE4", new AccionInsertarPartidoFase4());
    		acciones.put("CLASIFICACIONES", new AccionClasificaciones());
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String jsp = "index.jsp";
		// Cargamos la accion corespondiente
		Accion accion = acciones.get(request.getParameter("ID_ACCION"));
		try {
			// Ejecutamos la accion
			try {
				jsp = accion.ejecutar(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (java.lang.NullPointerException npe) {
			jsp = "index.jsp";
		}
		if(jsp.contains("Control")) {
			// Devolvemos al jsp correspondiente
			request.getRequestDispatcher(jsp).forward(request, response);
		}else {
			response.sendRedirect(jsp);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Llamar al doGet
		doGet(request, response);
	}

}
