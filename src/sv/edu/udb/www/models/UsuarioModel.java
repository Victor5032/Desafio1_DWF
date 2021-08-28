package sv.edu.udb.www.models;

import java.util.*;
import java.util.logging.*;
import java.sql.*;
import java.security.NoSuchAlgorithmException;

import sv.edu.udb.www.db.Conexion;
import sv.edu.udb.www.beans.*;
import sv.edu.udb.www.utils.Sha1;

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
			 
			this.desconectar();
			
			return response;
		} catch (SQLException e) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, e);
			
            this.desconectar();
            
            return 0;
		}
	}
	
	public Usuario perfil(String username) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE usuario = ?";
		
		Usuario usuario = new Usuario();
		
		try {
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setString(1, username);

			rs = cs.executeQuery();
			
			if (rs.next()) {
				usuario.setNombre(rs.getString("nombres"));
				usuario.setApellido(rs.getString("apellidos"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setCorreo(rs.getString("correo"));
			}
			 
			this.desconectar();
			
			return usuario;
		} catch (SQLException e) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, e);
			
            this.desconectar();
            
            return null;
		}
	}
	
	public int actualizarPerfil(String nombres, String apellidos, String usuario, String email, String usuarioActual) throws SQLException {
		int response = 0;
		
		String sql = "UPDATE usuarios SET nombres = ?, apellidos = ?, usuario = ?, correo = ? WHERE usuario = ?";
		
		try {
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setString(1, nombres);
			cs.setString(2, apellidos);
			cs.setString(3, usuario);
			cs.setString(4, email);
			cs.setString(5, usuarioActual);

			response = cs.executeUpdate();
			 
			this.desconectar();
			
			return response;
		} catch (SQLException e) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, e);
			
            this.desconectar();
            
            return 0;
		}
	}
	
	public String passwordActual(String user) throws SQLException {
		String password = null;
		
		String sql = "SELECT * FROM usuarios WHERE usuario = ?";
		
		Usuario usuario = new Usuario();
		
		try {
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setString(1, user);

			rs = cs.executeQuery();
			
			if (rs.next()) {
				password = rs.getString("password");
			}
			 
			this.desconectar();
			
			return password;
		} catch (SQLException e) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, e);
			
            this.desconectar();
            
            return null;
		}
	}
}
