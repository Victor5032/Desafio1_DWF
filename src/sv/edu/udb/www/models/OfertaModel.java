package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.www.beans.Oferta;
import sv.edu.udb.www.db.Conexion;

public class OfertaModel extends Conexion {
	// ciclo de ofertas realizadas por una emprsa
	public int insertarOfertaEnEspera(int idEmpresa, Oferta oferta) throws SQLException {
		try {
			int filasAfectadas = 0;
			String callSqlString = "CALL insertOfertaEnEspera(?,?,?,?,?,?,?,?,?)";
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
			cs.setString(9, oferta.getExtrasOferta());
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
	
		public Oferta obtnerOferta(int idOferta) throws SQLException {
		try {
			Oferta oferta = new Oferta();
			String sqlString = "CALL obtenerOferta(?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setInt(1, idOferta);
			rs = cs.executeQuery();
			if (rs.next()) {
				oferta.setIdOferta(rs.getInt("oferta_id"));
				oferta.setTituloOferta(rs.getString("titulo"));
				oferta.setDescripcionOferta(rs.getString("descripciom"));
				oferta.setFechaInicioOferta(rs.getDate("fecha_inicio"));
				oferta.setFechaFinOferta(rs.getDate("fecha_fin"));
				oferta.setPrecioRegularOferta(rs.getDouble("precio_regular"));
				oferta.setPrecio_ofertaOferta(rs.getDouble("precio_oferta"));
				oferta.setCantidadCuponesOferta(rs.getInt("cantidad_cupones"));
				oferta.setExtrasOferta(rs.getString("extras"));
				oferta.setObservacionesOferta(rs.getString("observaciones"));
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

	public int updateOferta(Oferta oferta) throws SQLException{
        try {
			int filasAfectadas = 0;
            String slqString = "CALL updateOferta(?,?,?,?,?,?,?,?,?)";
			this.conectar();
			cs = conexion.prepareCall(slqString);
			cs.setString(1, oferta.getTituloOferta());
			cs.setString(2, oferta.getDescripcionOferta());
			cs.setDouble(3, oferta.getPrecioRegularOferta());
			cs.setDouble(4, oferta.getPrecio_ofertaOferta());
			cs.setDate(5, oferta.getFechaInicioOferta());
			cs.setDate(6, oferta.getFechaFinOferta());
			cs.setInt(7, oferta.getCantidadCuponesOferta());
			cs.setString(8, oferta.getExtrasOferta());
			cs.setInt(9, oferta.getIdOferta());
            filasAfectadas = cs.executeUpdate();
			this.desconectar(); 
            return filasAfectadas;
		} catch (SQLException ex) {
			//TODO: handle exception
			Logger.getLogger(OfertaModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}
      
	}
}
