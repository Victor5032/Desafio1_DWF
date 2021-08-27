package sv.edu.udb.www.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sv.edu.udb.www.beans.Empresa;
import sv.edu.udb.www.models.EmpresaModel;
import sv.edu.udb.www.models.OfertaModel;
import sv.edu.udb.www.utils.CodigoEmpresa;

/**
 * Servlet implementation class EmpresaController
 */
@WebServlet(name = "EmpresaController", urlPatterns = { "/empresas.do" })
public class EmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<String> listaEventos = new ArrayList<>();
	EmpresaModel model = new EmpresaModel();
	Empresa empresa = new Empresa();
	OfertaModel ofertaModel = new OfertaModel();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			if (request.getParameter("op") == null) {
				if (session.getAttribute("usser") == null || session.getAttribute("name") == null) {
					request.getRequestDispatcher("/empresas/LoginEmpresas.jsp").forward(request, response);
				}
			}

			String opeacionString = request.getParameter("op");

			switch (opeacionString) {
			case "validar":
				try {
					validarEmpresa(request, response);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "nuevaEmpresa":
				registroEmpresa(request, response);
				break;
			case "completarValidar":
				request.getRequestDispatcher("/empresas/confirmarToken.jsp").forward(request, response);
				break;
//			case "TokenValidate":
//				tokenValidate(request, response);
//				break;
			case "logIn":
				request.getRequestDispatcher("/empresas/LoginEmpresas.jsp").forward(request, response);
				break;
			case "logInEmpresa":
				logIngEmpresa(request, response, session);
				break;
			case "logout":
				logoutEmpresa(request, response, session);
				break;
			case "perfilEmpresa":
				perfilEmpresa(request, response, session);
				break;
			case "update":
				updateEmpresa(request, response);
				break;
			case "updatePassword":
				updatePassword(request, response);
				break;
			case "recuperarPassword":
				recuperarPassword(request,response);
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

	private void registroEmpresa(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("rubros", model.listarRubros());
			request.getRequestDispatcher("/empresas/RegistroEmpresa.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
    
	//aqui nos quedamos
	private void recuperarPassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			String emailExiString = request.getParameter("correoEmpresa");
			
			
		} catch (Exception ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	private void updatePassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaEventos.clear();
            String actualPasswordString = request.getParameter("actualPassword");
            int empresaID = Integer.valueOf(request.getParameter("empresaID"));
            if(model.actualPasswordExists(actualPasswordString, empresaID) > 0 ) {
                String nwPasswordString = request.getParameter("newPassword");
                if(model.updatePassword(nwPasswordString, empresaID) > 0) {
                	listaEventos.add("Su contraseña ha sido modificada exitosamente.");
                	request.setAttribute("listaEventos", listaEventos);
                	request.getRequestDispatcher("empresas.do?op=perfilEmpresa").forward(request, response);
                }
            }else {
            	listaEventos.add("La contraseña ingresa no coincide con su contraseña actual");
            	request.setAttribute("listaEventos", listaEventos);
            	request.getRequestDispatcher("/empresas/changePassword.jsp").forward(request, response);
            }
            
		} catch (Exception ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void updateEmpresa(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaEventos.clear();
			Empresa miEmpresa = new Empresa();
			miEmpresa.setEmpresa_id(Integer.valueOf(request.getParameter("empresaID")));
			miEmpresa.setNombreEmpresa(request.getParameter("nombreEmpresa"));
			miEmpresa.setContactoEmpresa(request.getParameter("contacto"));
			miEmpresa.setDireccionEmpresa(request.getParameter("direccion"));
			miEmpresa.setTelefonoEmpresa(request.getParameter("telefono"));
			miEmpresa.setCorreoEmpresa(request.getParameter("correo"));
			miEmpresa.setRubro_id(Integer.valueOf(request.getParameter("rubro")));
			if (model.actualizarEmpresa(miEmpresa) > 0) {
				listaEventos.add("Su informacion se ha actualizado exitosamente");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("empresas.do?op=perfilEmpresa").forward(request, response);
			}
			int empresaID = Integer.valueOf(request.getParameter("empresaID"));
		} catch (SQLException | ServletException | IOException ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

//	private void tokenValidate(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			listaEventos.clear();
//			String userGetTokenString = request.getParameter("userToken");
//			if (model.verificarTokenExistente(userGetTokenString) > 0) {
//				listaEventos.add("Su cuenta ha sido verificada, Inicie sesion");
//				request.setAttribute("listaEventos", listaEventos);
//				response.sendRedirect(request.getContextPath() + "/empresas.do?op=logIn");
//			} else {
//				listaEventos.add("El token ingresado no es valido, vuelva a intentarlo");
//				request.setAttribute("listaEventos", listaEventos);
//				request.getRequestDispatcher("/empresas.do?op=completarValidar").forward(request, response);
//			}
//		} catch (SQLException | IOException | ServletException ex) {
//			// TODO: handle exception
//
//			Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}

	private void validarEmpresa(HttpServletRequest request, HttpServletResponse response) throws MessagingException {
		try {
			CodigoEmpresa codigoEmpresa = new CodigoEmpresa();
			empresa.setCodigo_empresa(codigoEmpresa.nuevoCodigoEmpresa());
			empresa.setNombreEmpresa(request.getParameter("empresaNombre"));
			empresa.setContactoEmpresa(request.getParameter("empresaContacto"));
			empresa.setDireccionEmpresa(request.getParameter("direccionEmpresa"));
			empresa.setTelefonoEmpresa(request.getParameter("telefonoEmpresa"));
			empresa.setCorreoEmpresa(request.getParameter("correoEmpresa"));
			empresa.setRubro_id(Integer.valueOf(request.getParameter("rubro")));
			empresa.setComisionEmpresa(Double.valueOf(request.getParameter("comision")));
			if (model.registrarEmpresaPendienteVerificaion(empresa) > 0) {
				request.getSession().setAttribute("exito", "Revise su correo electronico");
				response.sendRedirect(request.getContextPath() + "/admin.do?op=empresas");
			} else {
				request.getSession().setAttribute("fracaso", "something gone wrong");
				response.sendRedirect(request.getContextPath() + "/empresas.do?op=nuevaEmpresa");
			}

		} catch (IOException | SQLException | NoSuchAlgorithmException |MessagingException ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void perfilEmpresa(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			Empresa empresaLogueada = new Empresa();
			empresaLogueada = model.recuperarSesion(session.getAttribute("usser"));
			if (empresaLogueada != null) {
				request.setAttribute("rubro", model.listarRubros());
				request.setAttribute("listaOfertas", ofertaModel.ofertasEmpresa(empresaLogueada.getEmpresa_id()));
				request.setAttribute("empresa", empresaLogueada);
				request.getRequestDispatcher("/empresas/VerEmpresa.jsp").forward(request, response);
			}
		} catch (Exception ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void logIngEmpresa(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {

			listaEventos.clear();
			String correoEmpresaString = request.getParameter("correoEmpresa");
			String passwordEmpresaString = request.getParameter("passwordEmpresa");
			Empresa empresaLogIn = model.iniciarSesion(correoEmpresaString, passwordEmpresaString);
			if (empresaLogIn != null) {
				session.setAttribute("usser", empresaLogIn.getEmpresa_id());
				session.setAttribute("name", empresaLogIn.getNombreEmpresa());
				request.getRequestDispatcher("empresas.do?op=perfilEmpresa").forward(request, response);
			} else {
				listaEventos.add("El usuario o contraseña no son correctos");
				listaEventos.add("Ya activo su cuenta con el codigo de verificacion ?");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("empresas.do?op=logIn").forward(request, response);
			}
		} catch (IOException | SQLException | ServletException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void logoutEmpresa(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			session.removeAttribute("usser");
			session.removeAttribute("name");
			if (session.getAttribute("usser") == null || session.getAttribute("name") == null) {
				request.getRequestDispatcher("/empresas/LoginEmpresas.jsp").forward(request, response);
			}
		} catch (Exception ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
