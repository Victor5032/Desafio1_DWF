package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.www.db.*;
import sv.edu.udb.www.beans.*;

public class CuponModel extends Conexion {
	public void generarCupon(int cantidad, String codigo, int oferta, Date fecha) throws SQLException {
		ArrayList<String> cupones = new ArrayList<>();
		
		int min = 1000000;
	    int max = 9999999;
		
	    // Posible refactor
		for (int i = 0; i < cantidad; i++) {
			int random = (int) Math.floor(Math.random() * (max-min + 1) + min);
			String cupon = codigo + random;
			
			cupones.add(cupon);
		}
		
		String sql = "INSERT INTO cupones (oferta_id, codigo_promocional, fecha_vencimiento, estado) VALUES ";
		
		for (int i = 0; i < cupones.size(); i++) {
			if (i == (cupones.size() - 1)) {
				sql += "(" + oferta + ", '" + cupones.get(i) +"', '" + fecha + "', 1);"; 
			} else {
				sql += "(" + oferta + ", '" + cupones.get(i) +"', '" + fecha + "', 1),";
			}
		}
		// Posible refactor
		
		try {
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.executeUpdate();

			this.desconectar();
		} catch (SQLException e) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, e);

			this.desconectar();
		}
	}
	
	public List<Cupon> cuponesOferta(int id) throws SQLException {
		ArrayList<Cupon> cupones = new ArrayList<>();
		
		String sql = "SELECT * FROM cupones WHERE oferta_id = ?";
		
		try {
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setInt(1, id);
			
			rs = cs.executeQuery();
			
			while (rs.next()) {
				Cupon cupon = new Cupon();
				
				cupon.setCuponId(rs.getInt("cupon_id"));
				cupon.setCodigoPromocional(rs.getString("codigo_promocional"));
				cupon.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
				cupon.setFechaRegistro(rs.getDate("fecha_registro"));
				cupon.setEstado(rs.getInt("estado"));
				
				cupones.add(cupon);
			}

			this.desconectar();
			
			return cupones;
		} catch (SQLException e) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, e);

			this.desconectar();
			
			return null;
		}
	}
	
	/*CANTIDAD DE CUPONES*/
	public int cuponesCantidad(int idOferta) throws SQLException{
		try {
			
			int respuesta = 0;
			String sql="SELECT COUNT(*) AS cantidad FROM `cupones` WHERE oferta_id = ? AND estado = 1";
			this.conectar();
			cs=conexion.prepareCall(sql);
			
			cs.setInt(1, idOferta);
			
			rs=cs.executeQuery(); 
			
			if(rs.next()) {
				respuesta = rs.getInt("cantidad");
			}
			
			this.desconectar();
			return respuesta;
		}catch (SQLException ex) {

			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);
			
			this.desconectar();
			return 0;
		}
	}	
	
	public ClienteCupon obtenerCupon(String codigo) throws SQLException {
		String sql = "SELECT CONCAT(clientes.nombres, ' ', clientes.apellidos) AS cliente, clientes.dui, cupones.codigo_promocional, ofertas.titulo, ofertas.precio_regular, ofertas.precio_oferta, cupones.fecha_vencimiento, cupones.estado FROM cliente_cupones INNER JOIN cupones ON cupones.cupon_id = cliente_cupones.cupon_id INNER JOIN clientes ON clientes.cliente_id = cliente_cupones.cliente_id INNER JOIN ofertas ON ofertas.oferta_id = cupones.oferta_id WHERE cupones.codigo_promocional = ?";
		
		ClienteCupon datos = new ClienteCupon();
		
		try {
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setString(1, codigo);
			
			rs = cs.executeQuery();
			
			if (rs.next()) {
				String estado = null;
				
				datos.setCliente(rs.getString("cliente"));
				datos.setDui(rs.getString("dui"));
				datos.setCodigoCupon(rs.getString("codigo_promocional"));
				datos.setTituloClienteCupon(rs.getString("titulo"));
				datos.setPrecioRegular(rs.getDouble("precio_regular"));
				datos.setPrecioOferta(rs.getDouble("precio_oferta"));
				datos.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
				datos.setEstadoCupon(rs.getInt("estado"));
				
				if (rs.getInt("estado") == 2) {
					estado = "Comprado";
				}
				
				if (rs.getInt("estado") == 3) {
					estado = "Canjeado";
				}
				
				if (rs.getInt("estado") == 4) {
					estado = "Vencido";
				}
				
				datos.setEstado(estado);
			}
			
			this.desconectar();
			
			return datos;
		} catch (SQLException ex) {
			Logger.getLogger(CuponModel.class.getName()).log(Level.SEVERE, null, ex);
			
			this.desconectar();
		}
		
		return datos;
	}
	
	
	
	public ClienteCupon comprobarCupon(String codigo) {
		ClienteCupon response = new ClienteCupon();
		
		Date fechaActual = new Date();
		
		try {
			response = obtenerCupon(codigo);
			
			if (response.getFechaVencimiento().before(fechaActual)) {
				cuponVencido(codigo);
				
				response = obtenerCupon(codigo);
			}
		} catch (SQLException ex) {
			Logger.getLogger(CuponModel.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return response;
	}
	
	public int canjearCupon(String dui, String codigo) {
		int response = 0;
		
		try {
			if (cuponCanjeado(codigo) == 1) {
				response = 1;
			}
			
			return response;
		} catch (SQLException ex) {
			Logger.getLogger(CuponModel.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return response;
	}
	
	
	public void cuponVencido(String codigo) throws SQLException {
		String sql="UPDATE cupones SET estado = 4 WHERE codigo_promocional = ?";
		
		try {		
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setString(1, codigo);
			
			rs = cs.executeQuery(); 
			
			this.desconectar();

		}catch (SQLException ex) {

			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);
			
			this.desconectar();
		}
	}
	
	public int cuponCanjeado(String codigo) throws SQLException {
		int response = 0;
		
		String sql="UPDATE cupones SET estado = 3 WHERE codigo_promocional = ?";
		
		try {		
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setString(1, codigo);
			
			response = cs.executeUpdate(); 
			
			this.desconectar();
			
			return response;
		}catch (SQLException ex) {

			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);
			
			this.desconectar();
		}
		
		return response;
	}
}
