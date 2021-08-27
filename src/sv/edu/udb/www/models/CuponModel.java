package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.www.db.*;

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
}
