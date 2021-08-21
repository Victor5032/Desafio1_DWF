package sv.edu.udb.www.models;

import java.util.logging.*;
import java.sql.*;
import java.security.NoSuchAlgorithmException;

import sv.edu.udb.www.db.Conexion;
import sv.edu.udb.www.utils.Sha1;
// import sv.edu.udb.www.beans.Usuario;

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
			
			cs.execute();
			
			ResultSet resultSet = cs.getResultSet();
			
			if (resultSet.getString(1) == usuario && resultSet.getString(2) == password) {
				response = 1;
			} 
			
			return response;
		} catch (SQLException e) {
			Logger.getLogger(UsuarioModel.class.getName()).log(Level.SEVERE, null, e);
			
            this.desconectar();
            
            return 0;
		}
	}
}
