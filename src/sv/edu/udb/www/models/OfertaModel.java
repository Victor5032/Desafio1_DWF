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
}
