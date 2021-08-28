package sv.edu.udb.www.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sv.edu.udb.www.beans.Clientes;
import sv.edu.udb.www.models.ClientesModel;

/**
 * Servlet implementation class ClientesController
 */
@WebServlet(name = "ClientesController", urlPatterns = { "/clientes.do" })
public class ClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<String> listaEventos = new ArrayList<String>();
	ClientesModel modelo = new ClientesModel();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String operacionString = request.getParameter("op");

			switch (operacionString) {
			case "registrarClienteSinVerificar":
				ingresarClienteAverificar(request, response);
				break;
			case "verificacion":
				verificarCliente(request, response);
				break;
			default:
				break;
			}
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
	
	private void verificarCliente(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaEventos.clear();
			String clienteTokenString = request.getParameter("tokenCliente");
			if(modelo.verificarTokenExistente(clienteTokenString) > 0) {
				listaEventos.add("sua cuenta ha sido verificada con exito");
				listaEventos.add("inicie sesion con sus credenciales");
			    request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("/clientes/loginClientes.jsp").forward(request, response);
			}else {
				listaEventos.add("el token no es correcto, vuelva a intentarlo");
				request.setAttribute("listaEnventos",listaEventos);	
				request.getRequestDispatcher("/clientes/verificarToken.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	private void ingresarClienteAverificar(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaEventos.clear();
			Clientes miCliente = new Clientes();
			miCliente.setNombres(request.getParameter("nombreCliente"));
			miCliente.setApellidos(request.getParameter("apellidoCliente"));
			miCliente.setTelefono(request.getParameter("telefonoCliente"));
			miCliente.setDireccion(request.getParameter("direccionCliente"));
			miCliente.setDui(request.getParameter("duiCliente"));
			miCliente.setEmail(request.getParameter("emailCliente"));
			miCliente.setPassword(request.getParameter("passwordCliente"));
			if(modelo.registrarClientePendienteVerificaion(miCliente) > 0 ) {
				listaEventos.add("Se ha enviado un codigo de verificacion al correo indicado");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("/clientes/verificarToken.jsp").forward(request, response);
			}else {
				listaEventos.add("Ha surgido un problema, vuelva a intentarlo");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("/clientes/registroClientes.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	
}
