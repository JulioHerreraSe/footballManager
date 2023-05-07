package edu.ucam.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet Filter implementation class InicioDeSesion
 */
public class ZonaPrivada extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public ZonaPrivada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Creamos los objetos para poder usar request y response como en el servlet
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        if ("LISTARUSERS".equals(httpRequest.getParameter("ID_ACCION"))) {
            // Si es la URL que queremos filtrar, comprobar si el usuario está autorizado
            if ("admin".equals((String) httpRequest.getSession().getAttribute("user"))) {
                // Si el usuario está autorizado, permitir la petición
            	chain.doFilter(httpRequest, httpResponse);
            } else {
                // Si el usuario no está autorizado, redirigir al inicio de sesión
            	httpRequest.getServletContext().setAttribute("MSG_ERROR", "No tienes permiso");
    			// Redirijimos al index
    			httpRequest.getRequestDispatcher("index.jsp").forward(httpRequest, httpResponse);
            }
        } else {
            // Si no es la URL que queremos filtrar, permitir la petición
        	chain.doFilter(httpRequest, httpResponse);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
