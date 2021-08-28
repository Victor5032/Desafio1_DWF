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
import sv.edu.udb.www.models.OfertaModel;

/**
 * Servlet implementation class ClientesController
 */
@WebServlet(name = "ClientesController", urlPatterns = { "/clientes.do" })
public class ClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<String> listaEventos = new ArrayList<String>();
	ClientesModel modelo = new ClientesModel();
	OfertaModel ofertaModel = new OfertaModel();

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
			case "login":
				clienteLogin(request, response, session);
				break;
			case "logout":
				logoutCliente(request, response, session);
				break;
			case "forgotPassword":
				recuperarPassword(request, response);
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

	private void recuperarPassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaEventos.clear();
			String correoClienteString = request.getParameter("correoCliente");
			int clienteID = modelo.correoArecuperarExist(correoClienteString);
			if (clienteID > 0) {
				if (modelo.recuperarNuevoPassword(correoClienteString, clienteID) > 0) {
					listaEventos.add("Revise su correo");
					request.setAttribute("listaEventos", listaEventos);
					request.getRequestDispatcher("/clientes/loginClientes.jsp").forward(request, response);
				}
			} else {
				listaEventos.add("La direccion proporcionada no ha sido encontrada");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("/clientes/recuperarContraseña.jsp").forward(request, response);

			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private void logoutCliente(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			listaEventos.clear();
			session.removeAttribute("usser");
			session.removeAttribute("name");
			session.removeAttribute("apellido");
			if (session.getAttribute("usser") == null && session.getAttribute("name") == null
					&& session.getAttribute("apellido") == null) {
				request.getRequestDispatcher("/clientes/loginClientes.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private void clienteLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			Clientes miClientes = new Clientes();
			listaEventos.clear();
			String correoCleinteString = request.getParameter("correoCliente");
			String passwordString = request.getParameter("passwordCliente");
			miClientes = modelo.iniciarSesion(correoCleinteString, passwordString);
			if (miClientes != null) {
				session.setAttribute("usser", miClientes.getClienteID());
				session.setAttribute("name", miClientes.getNombres());
				session.setAttribute("apellido", miClientes.getApellidos());
				request.setAttribute("ofertasCupones", ofertaModel.obtenerOfertasClientes());
				request.getRequestDispatcher("/clientes/ofertasCupones.jsp").forward(request, response);
			} else {
				listaEventos.add("El correo o contraseña que ha ingresado no son correcto");
				listaEventos.add("Ya activo su cuenta ?");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("/clientes/loginClientes.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private void verificarCliente(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaEventos.clear();
			String clienteTokenString = request.getParameter("tokenCliente");
			if (modelo.verificarTokenExistente(clienteTokenString) > 0) {
				listaEventos.add("sua cuenta ha sido verificada con exito");
				listaEventos.add("inicie sesion con sus credenciales");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("/clientes/loginClientes.jsp").forward(request, response);
			} else {
				listaEventos.add("el token no es correcto, vuelva a intentarlo");
				request.setAttribute("listaEventos", listaEventos);
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
			String correoString = request.getParameter("emailCliente");
			if (modelo.verificarCorreoNoExiste(correoString) > 0) {
				Clientes miCliente = new Clientes();
				miCliente.setNombres(request.getParameter("nombreCliente"));
				miCliente.setApellidos(request.getParameter("apellidoCliente"));
				miCliente.setTelefono(request.getParameter("telefonoCliente"));
				miCliente.setDireccion(request.getParameter("direccionCliente"));
				miCliente.setDui(request.getParameter("duiCliente"));
				miCliente.setEmail(request.getParameter("emailCliente"));
				miCliente.setPassword(request.getParameter("passwordCliente"));
				if (modelo.registrarClientePendienteVerificaion(miCliente) > 0) {
					listaEventos.add("Se ha enviado un codigo de verificacion al correo indicado");
					request.setAttribute("listaEventos", listaEventos);
					request.getRequestDispatcher("/clientes/verificarToken.jsp").forward(request, response);
				} else {
					listaEventos.add("Ha surgido un problema, vuelva a intentarlo");
					request.setAttribute("listaEventos", listaEventos);
					request.getRequestDispatcher("/clientes/registroClientes.jsp").forward(request, response);
				}
			}else {
				listaEventos.add("Ya existe una cuenta asociada a esta direccion de correo");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("/clientes/registroClientes.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
