package sv.edu.udb.www.models;

import java.sql.SQLException;
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
			System.out.print(idOferta);
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
	
}
