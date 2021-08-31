package sv.edu.udb.www.controllers;

import java.io.*;
import java.util.*;
import java.util.logging.*;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import sv.edu.udb.www.beans.ClienteCupon;
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
			throws ServletException, IOException, DocumentException {
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
			case "perfil":
				perfilCliente(request, response);
				break;
			case "updateInfo":
				updateInfoCliente(request, response, session);
				break;
			case "updatePassword":
				changePassword(request, response);
				break;
				
			case "cuponPdf":
				generarPDF(request, response);
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
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaEventos.clear();
			String oldPasswoString = request.getParameter("actualPassword");
			int clienteID = Integer.valueOf(request.getParameter("clienteID"));
			if(modelo.actualPasswordExist(oldPasswoString, clienteID) > 0 ) {
				String newPasswordString = request.getParameter("newPassword");
				if(modelo.updatedPassword(newPasswordString, clienteID) > 0 ) {
					listaEventos.add("Su contraseña ha sido modificada");
					request.setAttribute("listaEventos", listaEventos);
					request.getRequestDispatcher("/clientes/cambiarPassword.jsp").forward(request, response);
				}
			}else {
				listaEventos.add("La contraseña que ha ingresado no coincide con su actual contraseña");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("/clientes/cambiarPassword.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	private void updateInfoCliente(HttpServletRequest request, HttpServletResponse response , HttpSession session) {
		try {
			
			listaEventos.clear();
            int clienteID = Integer.valueOf(request.getParameter("clienteID"));
			Clientes miCliente = new Clientes();
			miCliente.setNombres(request.getParameter("nombreCliente"));
			miCliente.setApellidos(request.getParameter("apellidoCliente"));
			miCliente.setDireccion(request.getParameter("direccionCliente"));
			miCliente.setTelefono(request.getParameter("telefonoCliente"));
			miCliente.setDui(request.getParameter("duiCliente"));
			miCliente.setEmail(request.getParameter("correoCliente"));
			if(modelo.UpdateClient(miCliente, clienteID) > 0) {
				session.setAttribute("name", miCliente.getNombres());
				session.setAttribute("apellido", miCliente.getApellidos());
				listaEventos.add("Su informacion se ha actualizado con exito");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("/clientes.do?op=perfil").forward(request, response);
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private void perfilCliente(HttpServletRequest request, HttpServletResponse response) {
		try {
			Clientes miCliente = new Clientes();
			int clienteId = Integer.valueOf(request.getParameter("clienteID"));
			miCliente = modelo.obtenerCliente(clienteId);
			if (miCliente != null) {
				request.setAttribute("listacupones", modelo.cuponesDeUncliente(clienteId));
				request.setAttribute("cliente", miCliente);
				request.getRequestDispatcher("/clientes/perfilCliente.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, e);
		}
	}

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
			} else {
				listaEventos.add("Ya existe una cuenta asociada a esta direccion de correo");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("/clientes/registroClientes.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public void generarPDF(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
		/*IModel fileModel =  new LoadableDetachableModel() {
			protected Object load() { 
		        // A hello world PDF
		        File f = null;
		        
				try {
					f = File.createTempFile("tempFile", null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        Document document = new Document();
		        
		        try {
					PdfWriter.getInstance(document, new FileOutputStream(f));
				} catch (FileNotFoundException | DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        document.open();
		        try {
					document.add(new Paragraph("Hello World!"));
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        document.close();
		        
		        return f;
		    }
		};
		
		DownloadLink link = new DownloadLink("cupon", fileModel, "cupon.pdf");
		// If you want to delete the file after it's been downloaded
		link.setDeleteAfterDownload(true);
		System.out.println(link);*/
		
		Document document = new Document();
        // step 2
		PdfWriter writer =  PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Victor López\\Documents\\Eclipse-Projects\\Desafio1_DWF\\WebContent\\pdf\\result.pdf"));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("Hello World"));
        document.add(new Paragraph(new Date().toString()));
        // step 5
        document.close();
        writer.close();
	}
}
