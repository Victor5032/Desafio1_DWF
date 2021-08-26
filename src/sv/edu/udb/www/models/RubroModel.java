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
			
			String sql = "SELECT * FROM rubros ORDER BY fecha_registro DESC";
			
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
}
