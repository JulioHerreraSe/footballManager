package edu.ucam.listerners;

import javax.naming.NamingException;

import edu.ucam.bd.ClubDAOSQL;
import edu.ucam.bd.JugadorDAOSQL;
import edu.ucam.bd.LigaDAOSQL;
import edu.ucam.bd.PartidoDAOSQL;
import edu.ucam.bd.UserDAOSQL;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class InicioApp
 *
 */
public class InicioApp implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicioApp() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	// Cargamos las bases de datos en el contexto
         sce.getServletContext().setAttribute("MSG_ERROR", "");
         try {
			sce.getServletContext().setAttribute("clubs", new ClubDAOSQL().listar());
			System.out.println("Cargada base de datos de clubs");
			sce.getServletContext().setAttribute("ligas", new LigaDAOSQL().listar());
			System.out.println("Cargada base de datos de ligas");
			sce.getServletContext().setAttribute("jugadores", new JugadorDAOSQL().listar());
			System.out.println("Cargada base de datos de jugadores");
			sce.getServletContext().setAttribute("partidos", new PartidoDAOSQL().listar());
			System.out.println("Cargada base de datos de partidos");
			sce.getServletContext().setAttribute("users", new UserDAOSQL().listar());
			System.out.println("Cargada base de datos de usuarios");
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
