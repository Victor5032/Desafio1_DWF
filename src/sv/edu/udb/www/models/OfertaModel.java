package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

	public int updateOferta(Oferta oferta, int idEmpresa) throws SQLException{
        try {
			int filasAfectadas = 0;
            String slqString = "CALL updateOferta(?,?,?,?,?,?,?,?,?,?)";
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
			cs.setInt(10, idEmpresa);
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
	
	//lista de ofertas a empresa espesifica
	public List<Oferta> ofertasEmpresa(int idEmpresa) throws SQLException {
		try {
			List<Oferta> lista = new ArrayList<>();

			String sql = "SELECT * FROM ofertas where empresa_id = (?) ORDER BY fecha_registro DESC";

			this.conectar();

			cs =  conexion.prepareCall(sql);
			cs.setInt(1, idEmpresa);
			rs = cs.executeQuery();

			while (rs.next()) {
				Oferta oferta = new Oferta();
				oferta.setIdOferta(rs.getInt("oferta_id"));
				oferta.setTituloOferta(rs.getString("titulo"));
				oferta.setDescripcionOferta(rs.getString("descripcion"));
				oferta.setPrecioRegularOferta(rs.getDouble("precio_regular"));
				oferta.setPrecio_ofertaOferta(rs.getDouble("precio_oferta"));
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
		
		
	
	public List<Oferta> ofertas() throws SQLException {
		try {
			List<Oferta> lista = new ArrayList<>();
			
			String sql = "SELECT * FROM ofertas ORDER BY fecha_registro DESC";
			
			this.conectar();
			
			cs =  conexion.prepareCall(sql);
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
		try {			
			String sql = "SELECT * FROM ofertas ";
			
			this.conectar();
			
			/*cs =  conexion.prepareCall(sql);
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
			}*/
			
			this.desconectar();
			
			return 0;
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return 0;
		}
	}
	
	public int validarOferta(String codigo, String estado, String observaciones) throws SQLException {
		int response = 0;
		
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
			
			cs =  conexion.prepareCall(sql);
			
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
}
