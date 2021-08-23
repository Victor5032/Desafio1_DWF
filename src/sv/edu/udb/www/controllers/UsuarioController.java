package sv.edu.udb.www.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.security.NoSuchAlgorithmException;

import sv.edu.udb.www.models.*;
import sv.edu.udb.www.beans.*;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet(name = "UsuarioController", urlPatterns = { "/admin.do" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoSuchAlgorithmException, SQLException {
		HttpSession session = request.getSession();
		 
		try (PrintWriter out = response.getWriter()) {
			if (request.getParameter("op") == null) {
				if (session.getAttribute("sesion") != null) {
					response.sendRedirect("admin.do?op=home");
				} else {
					request.getRequestDispatcher("/admin/Loginadmin.jsp").forward(request, response);
				}
				
				return;
			}
			
			UsuarioModel model = new UsuarioModel();
			OfertaModel ofertaModel = new OfertaModel();

			String op = request.getParameter("op");

			switch (op) {
				case "login":
					String user = request.getParameter("usuario");
					String password = request.getParameter("password");

					if (model.loginAdmin(user, password) > 0) {
						session.setAttribute("usuario", user);
						session.setAttribute("sesion", 1);
						
						response.sendRedirect("admin.do?op=home");
					} else {						
						request.getRequestDispatcher("/admin/Loginadmin.jsp").forward(request, response);
					}
					
					break;
				
				case "home":
					loginRequired(response, session);
					
					request.setAttribute("ofertas", ofertaModel.ofertas());

					request.getRequestDispatcher("/admin/inicio.jsp").forward(request, response);
					break;
				
				case "details":
					loginRequired(response, session);
					
					request.setAttribute("oferta", "Hola");
					
					request.getRequestDispatcher("/admin/detalles.jsp").forward(request, response);
					break;
			
			
				default:
					
					break;
			}
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (NoSuchAlgorithmException | ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (NoSuchAlgorithmException | ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void loginRequired(HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		if (session.getAttribute("sesion") == null) {
			response.sendRedirect("admin.do");
		}
	}
}
