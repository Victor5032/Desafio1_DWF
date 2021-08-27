package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.www.db.*;
import sv.edu.udb.www.beans.Rubro;

public class RubroModel extends Conexion {
	public List<Rubro> rubros() throws SQLException {
		try {
			List<Rubro> lista = new ArrayList<>();
			
			String sql = "SELECT * FROM rubros WHERE estado = 1 ORDER BY fecha_registro DESC";
			
			this.conectar();
			
			cs =  conexion.prepareCall(sql);
			rs = cs.executeQuery();
			
			while (rs.next()) {
				Rubro rubro = new Rubro();

				rubro.setRubroID(rs.getInt("rubro_id"));
				rubro.setRubro(rs.getString("rubro"));
				rubro.setFecha_registro(rs.getDate("fecha_registro"));
				rubro.setEstado(rs.getInt("estado"));
				
				lista.add(rubro);
			}
			
			this.desconectar();
			
			return lista;
		} catch (SQLException ex) {
			Logger.getLogger(RubroModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return null;
		}
	}
	
	public Rubro obtenerRubro(int id) throws SQLException {
		try {
			Rubro rubro = new Rubro();
			
			String sql = "SELECT * FROM rubros WHERE rubro_id = ?";
			
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setInt(1, id);
			
			rs = cs.executeQuery();
			
			if (rs.next()) {
				rubro.setRubroID(rs.getInt("rubro_id"));
				rubro.setRubro(rs.getString("rubro"));
				rubro.setFecha_registro(rs.getDate("fecha_registro"));
				rubro.setEstado(rs.getInt("estado"));
				
				this.desconectar();
				
				return rubro;
			}
			
			this.desconectar();
			
			return rubro;
		} catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);
			
			this.desconectar();
			
			return null;
		}
	}
	
	public int nuevoRubro(String rubro) throws SQLException {
		String sql = "INSERT INTO rubros (rubro, estado) VALUES (?, 1)";
		
		try {
			int response = 0;
			
			this.conectar();
			cs = conexion.prepareCall(sql);
			
			cs.setString(1, rubro);
			
			response = cs.executeUpdate();
			
			this.desconectar();
			
			return response;
		} catch (SQLException e) {
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, e);
			
			this.desconectar();
			
			return 0;
		}
	}
	
	public int editarRubro(String rubro, int id) throws SQLException {
		String sql = "UPDATE rubros SET rubro = ? WHERE rubro_id = ?";
		
		try {
			int response = 0;
			
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setString(1, rubro);
			cs.setInt(2, id);
			
			response = cs.executeUpdate();
			
			this.desconectar();
			
			return response;
		} catch (SQLException e) {
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, e);
			
			this.desconectar();
			
			return 0;
		}
	}
	
	public int buscarRubro(String nombre) throws SQLException {
		String sql = "SELECT rubro_id FROM rubros WHERE rubro = ?";
		
		try {
			int response = 0;
			
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setString(1, nombre);
			
			rs = cs.executeQuery();
			
			rs.last();
			
			response = rs.getInt("rubro_id");
			
			this.desconectar();
			
			return response;
		} catch (SQLException e) {
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, e);
			
			this.desconectar();
			
			return 0;
		}
	}
	
	public int borrarRubro(int id) throws SQLException {
		String sql = "UPDATE rubros SET estado = 2 WHERE rubro_id = ?";
		
		try {
			int response = 0;
			
			this.conectar();
			
			cs = conexion.prepareCall(sql);

			cs.setInt(1, id);
			
			response = cs.executeUpdate();
			
			this.desconectar();
			
			return response;
		} catch (SQLException e) {
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, e);
			
			this.desconectar();
			
			return 0;
		}
	}
}
