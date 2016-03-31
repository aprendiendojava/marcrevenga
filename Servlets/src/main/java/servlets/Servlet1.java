package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String initParam;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		// getContextPath --> Ruta de aplicación web --> /Servlets
//		
//		response.getWriter().append(" Método: " + request.getMethod());
//		
//		//getMethod --> Obtenemos tipo de peticion: GTE, POST, ...
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<strong>Mensaje desde el servlet</strong>");
		
		String codigoParam = request.getParameter("codigo");
		if(codigoParam == null)
			codigoParam="No existe el parámetro código";
		
		out.println("<p>Código: " + codigoParam + "</p>");
		out.println("<p>Path Info: " + request.getPathInfo() + "</p>");
		out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
		out.println("<p>Servlet Path: " + request.getServletPath() + "</p>");
		out.println("<p>Request URL: " + request.getRequestURL() + "</p>");
		
		out.println("<p>Parámetro inicial: " + initParam + "</p>");
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		initParam = config.getInitParameter("parametro");
	}
	
	

}
