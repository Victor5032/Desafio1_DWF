package sv.edu.udb.www.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sv.edu.udb.www.beans.Oferta;
import sv.edu.udb.www.models.OfertaModel;

/**
 * Servlet implementation class OfertaController
 */
@WebServlet(name = "OfertaController", urlPatterns = { "/ofertas.do" })
public class OfertaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<String> listaEventos = new ArrayList<>();
	OfertaModel model = new OfertaModel();

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			if (request.getParameter("op") == null) {
				if (session.getAttribute("usser") == null && session.getAttribute("name") == null) {
					request.getRequestDispatcher("/empresas/LoginEmpresas.jsp").forward(request, response);
				}
			}

			String opeacionString = request.getParameter("op");

			switch (opeacionString) {
			case "insert":
				insertOfertaEnEspera(request, response);
				break;
			case "detallesOferta":
				detallesOferta(request, response);
				break;
			case "ofertaObtenida":
				request.getRequestDispatcher("/empresas/EditarOfertar.jsp").forward(request, response);
				break;
			case "updateOferta":
				updateOferta(request, response);
				break;
			case "delete":
				deleteOferta(request, response);
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

	
	private void deleteOferta(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaEventos.clear();
			int ofertID = Integer.valueOf(request.getParameter("ofertaID"));
			if(model.eliminarOFerta(ofertID) > 0 ) {
				listaEventos.add("La oferta ha sido eliminada de manera exitosa");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("empresas.do?op=perfilEmpresa").forward(request, response);
			}
		} catch (Exception ex) {
			// TODO: handle exception
			Logger.getLogger(OfertaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private void insertOfertaEnEspera(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			listaEventos.clear();
			int idEmpresa = Integer.valueOf(request.getParameter("empresaID"));
			Oferta miOferta = new Oferta();
			miOferta.setTituloOferta(request.getParameter("ofertaTitulo"));
			miOferta.setDescripcionOferta(request.getParameter("ofertaDescripcion"));
			miOferta.setPrecioRegularOferta(Double.valueOf(request.getParameter("regularOferta")));
			miOferta.setPrecio_ofertaOferta(Double.valueOf(request.getParameter("ofertaOferta")));
			miOferta.setFechaInicioOferta(Date.valueOf(request.getParameter("ofertaInicio")));
			miOferta.setFechaFinOferta(Date.valueOf(request.getParameter("ofertaFinal")));
			miOferta.setCantidadCuponesOferta(Integer.valueOf(request.getParameter("ofertaCantidadCupones")));
			miOferta.setExtrasOferta(request.getParameter("ofertasExtras"));
			if (model.insertarOfertaEnEspera(idEmpresa, miOferta) > 0) {
				listaEventos.add("Oferta enviada a revision con exito");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("empresas.do?op=perfilEmpresa").forward(request, response);
			}
		} catch (Exception ex) {
			// TODO: handle exception
			Logger.getLogger(OfertaController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	private void detallesOferta(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			int idOferta = Integer.valueOf(request.getParameter("idOferta"));
			Oferta getOferta = model.obtenerOferta(idOferta);
			if (getOferta != null) {
				request.setAttribute("oferta", getOferta);
				request.getRequestDispatcher("/ofertas.do?op=ofertaObtenida").forward(request, response);
			}
		} catch (IOException | SQLException | ServletException ex) {
			// TODO: handle exception
			Logger.getLogger(OfertaController.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	private void updateOferta(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaEventos.clear();
			Oferta miOferta = new Oferta();
			int idEmpresa = Integer.valueOf(request.getParameter("empresaID"));
			miOferta.setIdOferta(Integer.valueOf(request.getParameter("ofertaID")));
			miOferta.setTituloOferta(request.getParameter("ofertaTitulo"));
			miOferta.setDescripcionOferta(request.getParameter("ofertaDescripcion"));
			miOferta.setPrecioRegularOferta(Double.valueOf(request.getParameter("regularOferta")));
			miOferta.setPrecio_ofertaOferta(Double.valueOf(request.getParameter("ofertaOferta")));
			miOferta.setFechaInicioOferta(Date.valueOf(request.getParameter("ofertaInicio")));
			miOferta.setFechaFinOferta(Date.valueOf(request.getParameter("ofertaFinal")));
			miOferta.setCantidadCuponesOferta(Integer.valueOf(request.getParameter("ofertaCantidadCupones")));
			miOferta.setExtrasOferta(request.getParameter("ofertasExtras"));
			if (model.updateOferta(miOferta, idEmpresa) > 0) {
				listaEventos.add("La oferta fue actualizada y ha sido enviada a revision nuevamente");
				request.setAttribute("listaEventos", listaEventos);
				request.getRequestDispatcher("empresas.do?op=perfilEmpresa").forward(request, response);
			}
		} catch (Exception ex) {
			// TODO: handle exception
			Logger.getLogger(OfertaController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
