package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.www.beans.Oferta;
import sv.edu.udb.www.db.Conexion;
import sv.edu.udb.www.utils.SendEmail;

public class OfertaModel extends Conexion {
	// ciclo de ofertas realizadas por una emprsa
	public int insertarOfertaEnEspera(int idEmpresa, Oferta oferta) throws SQLException {
		try {
			int filasAfectadas = 0;
			String callSqlString = "CALL insertOfertaEnEspera(?,?,?,?,?,?,?,?,?,?)";
			this.conectar();
			cs = conexion.prepareCall(callSqlString);
			cs.setInt(1, idEmpresa);
			cs.setString(2, oferta.getTituloOferta());
			cs.setString(3, oferta.getDescripcionOferta());
			cs.setDouble(4, oferta.getPrecioRegularOferta());
			cs.setDouble(5, oferta.getPrecio_ofertaOferta());
			cs.setDate(6, oferta.getFechaInicioOferta());
			cs.setDate(7, oferta.getFechaFinOferta());
			cs.setInt(8, oferta.getCantidadCuponesOferta());
			cs.setDouble(9, oferta.getPrecioXcupon());
			cs.setString(10, oferta.getExtrasOferta());
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}
	}

	public Oferta obtenerOferta(int idOferta) throws SQLException {
		try {
			Oferta oferta = new Oferta();

			String sqlString = "SELECT * FROM ofertas WHERE oferta_id = ?";

			this.conectar();

			cs = conexion.prepareCall(sqlString);

			cs.setInt(1, idOferta);

			rs = cs.executeQuery();

			if (rs.next()) {
				EmpresaModel empresa = new EmpresaModel();

				String nombreEmpresa = empresa.obtenerEmpresa(rs.getInt("empresa_id")).getNombreEmpresa();

				oferta.setIdOferta(rs.getInt("oferta_id"));
				oferta.setNombreEmpresa(nombreEmpresa);
				oferta.setTituloOferta(rs.getString("titulo"));
				oferta.setDescripcionOferta(rs.getString("descripcion"));
				oferta.setFechaInicioOferta(rs.getDate("fecha_inicio"));
				oferta.setFechaFinOferta(rs.getDate("fecha_fin"));
				oferta.setPrecioRegularOferta(rs.getDouble("precio_regular"));
				oferta.setPrecio_ofertaOferta(rs.getDouble("precio_oferta"));
				oferta.setCantidadCuponesOferta(rs.getInt("cantidad_cupones"));
				oferta.setPrecioXcupon(rs.getDouble("precio_cupones"));
				oferta.setExtrasOferta(rs.getString("extras"));
				oferta.setObservacionesOferta(rs.getString("observaciones"));
				oferta.setEstadoOferta(rs.getInt("estado"));
				this.desconectar();
				return oferta;
			}
			this.desconectar();
			return oferta;
		} catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return null;
		}
	}

	public int eliminarOFerta(int idOferta) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sqlString = "CALL deleteOferta(?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setInt(1, idOferta);
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}
	}

	public int updateOferta(Oferta oferta, int idEmpresa) throws SQLException {
		try {
			int filasAfectadas = 0;
			String slqString = "CALL updateOferta(?,?,?,?,?,?,?,?,?,?,?)";
			this.conectar();
			cs = conexion.prepareCall(slqString);
			cs.setString(1, oferta.getTituloOferta());
			cs.setString(2, oferta.getDescripcionOferta());
			cs.setDouble(3, oferta.getPrecioRegularOferta());
			cs.setDouble(4, oferta.getPrecio_ofertaOferta());
			cs.setDate(5, oferta.getFechaInicioOferta());
			cs.setDate(6, oferta.getFechaFinOferta());
			cs.setInt(7, oferta.getCantidadCuponesOferta());
			cs.setDouble(8, oferta.getPrecioXcupon());
			cs.setString(9, oferta.getExtrasOferta());
			cs.setInt(10, oferta.getIdOferta());
			cs.setInt(11, idEmpresa);
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}

	}

	// lista de ofertas a empresa espesifica
	public List<Oferta> ofertasEmpresa(int idEmpresa) throws SQLException {
		try {
			List<Oferta> lista = new ArrayList<>();

			String sql = "SELECT * FROM ofertas where empresa_id = (?) ORDER BY fecha_registro DESC";

			this.conectar();

			cs = conexion.prepareCall(sql);
			cs.setInt(1, idEmpresa);
			rs = cs.executeQuery();

			while (rs.next()) {
				Oferta oferta = new Oferta();
				oferta.setIdOferta(rs.getInt("oferta_id"));
				oferta.setTituloOferta(rs.getString("titulo"));
				oferta.setCantidadCuponesOferta(rs.getInt("cantidad_cupones"));
				oferta.setDescripcionOferta(rs.getString("descripcion"));
				oferta.setPrecioRegularOferta(rs.getDouble("precio_regular"));
				oferta.setPrecio_ofertaOferta(rs.getDouble("precio_oferta"));
				oferta.setFechaInicioOferta(rs.getDate("fecha_inicio"));
				oferta.setFechaFinOferta(rs.getDate("fecha_fin"));
				oferta.setFechaRegistroOferta(rs.getDate("fecha_registro"));
				oferta.setEstadoOferta(rs.getInt("estado"));

				lista.add(oferta);
			}

			this.desconectar();

			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return null;
		}
	}

	public String codigoEmpresa(int oferta) throws SQLException {
		String sql = "SELECT empresas.codigo FROM ofertas INNER JOIN empresas ON empresas.empresa_id = ofertas.empresa_id WHERE ofertas.oferta_id = ?";

		try {
			String response = null;

			this.conectar();

			cs = conexion.prepareCall(sql);

			cs.setInt(1, oferta);

			rs = cs.executeQuery();

			rs.last();

			response = rs.getString("codigo");

			this.desconectar();

			return response;
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return null;
		}
	}

	public Date obtenerFechaVencimiento(String oferta) throws SQLException {
		String sql = "SELECT fecha_fin FROM ofertas WHERE oferta_id = ?";

		try {
			Date response = null;

			this.conectar();

			cs = conexion.prepareCall(sql);

			cs.setString(1, oferta);

			rs = cs.executeQuery();

			rs.last();

			response = rs.getDate("fecha_fin");

			this.desconectar();

			return response;
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return null;
		}
	}

	public List<Oferta> ofertas() throws SQLException {
		try {
			List<Oferta> lista = new ArrayList<>();

			String sql = "SELECT * FROM ofertas ORDER BY fecha_registro DESC";

			this.conectar();

			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();

			while (rs.next()) {
				Oferta oferta = new Oferta();
				EmpresaModel empresa = new EmpresaModel();

				String nombreEmpresa = empresa.obtenerEmpresa(rs.getInt("empresa_id")).getNombreEmpresa();

				oferta.setIdOferta(rs.getInt("oferta_id"));
				oferta.setNombreEmpresa(nombreEmpresa);
				oferta.setTituloOferta(rs.getString("titulo"));
				oferta.setDescripcionOferta(rs.getString("descripcion"));
				oferta.setPrecioRegularOferta(rs.getDouble("precio_regular"));
				oferta.setPrecio_ofertaOferta(rs.getDouble("precio_oferta"));
				oferta.setFechaInicioOferta(rs.getDate("fecha_inicio"));
				oferta.setFechaFinOferta(rs.getDate("fecha_fin"));
				oferta.setCantidadCuponesOferta(rs.getInt("cantidad_cupones"));
				oferta.setFechaRegistroOferta(rs.getDate("fecha_registro"));
				oferta.setEstadoOferta(rs.getInt("estado"));

				lista.add(oferta);
			}

			this.desconectar();

			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return null;
		}
	}

	public int cantidadCupones(int codigo) throws SQLException {
		String sql = "SELECT cantidad_cupones FROM ofertas WHERE oferta_id = ?";

		try {
			int response = 0;

			this.conectar();

			cs = conexion.prepareCall(sql);

			cs.setInt(1, codigo);

			rs = cs.executeQuery();

			rs.last();

			response = rs.getInt("cantidad_cupones");
			this.desconectar();

			return response;
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return 0;
		}
	}

	public List<Oferta> obtenerOfertasClientes() throws SQLException {

		try {
			List<Oferta> listaOfertaDisponibles = new ArrayList();
			String sql = "SELECT * FROM `ofertas` WHERE ofertas.estado = 1 and LOCALTIMESTAMP() >= ofertas.fecha_inicio and LOCALTIMESTAMP() <= ofertas.fecha_fin";
			this.conectar();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();

			while (rs.next()) {
				CuponModel cupones = new CuponModel();
				Oferta misOfertas = new Oferta();
				misOfertas.setIdOferta(rs.getInt("oferta_id"));
				misOfertas.setIdEmpresaOferta(rs.getInt("empresa_id"));
				misOfertas.setTituloOferta(rs.getString("titulo"));
				misOfertas.setDescripcionOferta(rs.getString("descripcion"));
				misOfertas.setPrecioRegularOferta(rs.getDouble("precio_regular"));
				misOfertas.setPrecio_ofertaOferta(rs.getDouble("precio_oferta"));
				misOfertas.setFechaInicioOferta(rs.getDate("fecha_inicio"));
				misOfertas.setFechaFinOferta(rs.getDate("fecha_fin"));
				misOfertas.setCantidadCuponesOferta(cupones.cuponesCantidad(rs.getInt("oferta_id")));
				listaOfertaDisponibles.add(misOfertas);
			}

			this.desconectar();
			return listaOfertaDisponibles;
		} catch (SQLException ex) {

			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();
			return null;
		}

	}

	public int validarOferta(String codigo, String estado, String observaciones) throws SQLException {
		int response = 0;
		int cupones = 0;
		String codigoEmpresa = null;

		String sql = "UPDATE ofertas SET estado = ?, observaciones = ? WHERE oferta_id = ?";

		if (observaciones.equals("")) {
			observaciones = null;
		}

		try {
			this.conectar();

			cs = conexion.prepareCall(sql);

			cs.setString(1, estado);
			cs.setString(2, observaciones);
			cs.setString(3, codigo);

			response = cs.executeUpdate();

			if (Integer.parseInt(estado) == 1) {
				cupones = cantidadCupones(Integer.parseInt(codigo));
				System.out.println("cupones: " + cupones);
				Date fechaVencimiento = obtenerFechaVencimiento(codigo);
				System.out.println("vencimiento: " + fechaVencimiento);
				if (cupones > 0) {
					CuponModel cupon = new CuponModel();

					codigoEmpresa = codigoEmpresa(Integer.parseInt(codigo));
					System.out.println("empresa: " + codigoEmpresa);
					cupon.generarCupon(cupones, codigoEmpresa, Integer.parseInt(codigo), fechaVencimiento);
				}
			}

			this.desconectar();

			return response;
		} catch (SQLException e) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, e);

			this.desconectar();

			return response;
		}
	}

	public List<Oferta> ofertasEstado(int estado) throws SQLException {
		try {
			List<Oferta> lista = new ArrayList<>();

			String sql = "SELECT * FROM ofertas WHERE estado = ? ORDER BY fecha_registro DESC";

			this.conectar();

			cs = conexion.prepareCall(sql);

			cs.setInt(1, estado);

			rs = cs.executeQuery();

			while (rs.next()) {
				Oferta oferta = new Oferta();
				EmpresaModel empresa = new EmpresaModel();

				String nombreEmpresa = empresa.obtenerEmpresa(rs.getInt("empresa_id")).getNombreEmpresa();

				oferta.setIdOferta(rs.getInt("oferta_id"));
				oferta.setNombreEmpresa(nombreEmpresa);
				oferta.setTituloOferta(rs.getString("titulo"));
				oferta.setDescripcionOferta(rs.getString("descripcion"));
				oferta.setPrecioRegularOferta(rs.getDouble("precio_regular"));
				oferta.setPrecio_ofertaOferta(rs.getDouble("precio_oferta"));
				oferta.setFechaInicioOferta(rs.getDate("fecha_inicio"));
				oferta.setFechaFinOferta(rs.getDate("fecha_fin"));
				oferta.setCantidadCuponesOferta(rs.getInt("cantidad_cupones"));
				oferta.setFechaRegistroOferta(rs.getDate("fecha_registro"));
				oferta.setEstadoOferta(rs.getInt("estado"));

				lista.add(oferta);
			}

			this.desconectar();

			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return null;
		}
	}

	public Oferta mostrarDetallesCupon(int idOferta) throws SQLException {

		try {
			Oferta verDetalle = new Oferta();
			String sql = "SELECT * FROM `ofertas` WHERE oferta_id = ?";
			this.conectar();
			cs = conexion.prepareCall(sql);

			cs.setInt(1, idOferta);

			rs = cs.executeQuery();

			if (rs.next()) {
				CuponModel cupones = new CuponModel();
				verDetalle.setTituloOferta(rs.getString("titulo"));
				verDetalle.setIdOferta(rs.getInt("oferta_id"));
				verDetalle.setDescripcionOferta(rs.getString("descripcion"));
				verDetalle.setPrecioRegularOferta(rs.getDouble("precio_regular"));
				verDetalle.setPrecio_ofertaOferta(rs.getDouble("precio_oferta"));
				verDetalle.setCantidadCuponesOferta(cupones.cuponesCantidad(rs.getInt("oferta_id")));
			}

			this.desconectar();
			return verDetalle;
		} catch (SQLException ex) {

			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();
			return null;
		}

	}

	public String cuponDisponible(int idOferta) throws SQLException {
		try {
			String respuesta = null;
			String sql = "SELECT * FROM `cupones` WHERE oferta_id = ? and estado = 1 LIMIT 1";
			this.conectar();
			cs = conexion.prepareCall(sql);

			cs.setInt(1, idOferta);

			rs = cs.executeQuery();

			if (rs.next()) {
				respuesta = rs.getString("codigo_promocional");
			}

			this.desconectar();
			return respuesta;
		} catch (SQLException ex) {

			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();
			return null;
		}
	}

	public int cuponId(String codigo) throws SQLException {
		try {
			int respuesta = 0;
			String sql = "SELECT cupon_id FROM `cupones` WHERE codigo_promocional = ?";

			this.conectar();

			cs = conexion.prepareCall(sql);

			cs.setString(1, codigo);

			rs = cs.executeQuery();

			if (rs.next()) {
				respuesta = rs.getInt("cupon_id");
			}

			this.desconectar();

			return respuesta;
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return 0;
		}
	}

	public int cambiarEstadoCupon(int codigo_id) throws SQLException {
		try {
			int respuesta = 0;
			String sql = "UPDATE cupones SET estado = 2 WHERE cupon_id = ?";

			this.conectar();

			cs = conexion.prepareCall(sql);

			cs.setInt(1, codigo_id);

			cs.executeUpdate();

			this.desconectar();

			return respuesta;
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return 0;
		}
	}

	public int asignarCuponCliente(int cupon_id, int cliente_id, int ultimos4) throws SQLException {

		String sql = "INSERT INTO cliente_cupones (cupon_id, cliente_id, ultimos4) VALUES (?, ?, ?)";

		try {
			int response = 0;

			this.conectar();

			cs = conexion.prepareCall(sql);

			cs.setInt(1, cupon_id);
			cs.setInt(2, cliente_id);
			cs.setInt(3, ultimos4);

			response = cs.executeUpdate();

			this.desconectar();
			emailConfirmandoPago(cliente_id, cupon_id);
			return response;
		} catch (SQLException e) {
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, e);

			this.desconectar();

			return 0;
		}
	}

	public void emailConfirmandoPago(int clienteID, int cuponID) throws SQLException {
		try {
			SendEmail confirMacionPagoEmail = new SendEmail();
// datos del clientes
			String nombreSClienteString = "";
			String apellidoString = "" ;
			String correoClienteString = "";
			String codigoCupon = "";
			String sqlString = "SELECT clientes.nombres, clientes.apellidos, clientes.email from clientes WHERE clientes.cliente_id = ? ";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setInt(1, clienteID);
			rs = cs.executeQuery();
			if(rs.next()) {
				nombreSClienteString = rs.getString("nombres");
				apellidoString = rs.getString("apellidos");
			    correoClienteString = rs.getString("email");
			}
			this.desconectar();
//		codigo del cupon
			String sqlString2 = "SELECT cupones.codigo_promocional from cupones WHERE cupones.cupon_id = ?";
			this.conectar();
			cs = conexion.prepareCall(sqlString2);
			cs.setInt(1, cuponID);
			rs = cs.executeQuery();
			if(rs.next()) {
				codigoCupon = rs.getString("codigo_promocional");
			}
 			this.desconectar();
			confirMacionPagoEmail.conFirmacionPago(correoClienteString, nombreSClienteString, apellidoString, codigoCupon);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, e);

			this.desconectar();
		}

	}

}
