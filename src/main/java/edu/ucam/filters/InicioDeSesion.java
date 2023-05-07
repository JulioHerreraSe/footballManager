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
public class InicioDeSesion extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public InicioDeSesion() {
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
        // Si la peticion viene del login la dejamos entrar
		if(request.getParameter("nameLogin") != null) {
			chain.doFilter(httpRequest, httpResponse);
			// Si no esta iniciada la sesion te redirije al index
		} else if(httpRequest.getSession().getAttribute("user") == null){
			// Añadimos el mensaje de comunicación con el cliente
			httpRequest.getServletContext().setAttribute("MSG_ERROR", "Debes iniciar sesión");
			// Redirijimos al index
			httpRequest.getRequestDispatcher("index.jsp").forward(httpRequest, httpResponse);
		} else {
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
