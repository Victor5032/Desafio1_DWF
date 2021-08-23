package sv.edu.udb.www.models;

import java.util.*;
import java.util.logging.*;
import java.sql.*;
import java.security.NoSuchAlgorithmException;

import sv.edu.udb.www.db.Conexion;
import sv.edu.udb.www.utils.Sha1;
import sv.edu.udb.www.beans.Oferta;
import sv.edu.udb.www.models.EmpresaModel;

public class UsuarioModel extends Conexion {
	public int loginAdmin(String usuario, String password) throws SQLException, NoSuchAlgorithmException {
		Sha1 sha1 = new Sha1();
		
		int response = 0;
		
		String sql = "SELECT usuario_id, usuario, password FROM usuarios WHERE (usuario = ? AND password = ?) AND estado = 1";
		
		try {
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setString(1, usuario);
			cs.setString(2, sha1.sha1Hash(password));

			rs = cs.executeQuery();
			
			if (rs.next()) {
				response = 1;
			}
			
			return response;
		} catch (SQLException e) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, e);
			
            this.desconectar();
            
            return 0;
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
				// System.out.println(rs.getInt("oferta_id"));
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
