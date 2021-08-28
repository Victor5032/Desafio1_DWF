package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.www.beans.Clientes;
import sv.edu.udb.www.db.Conexion;
import sv.edu.udb.www.utils.CodigoEmpresa;
import sv.edu.udb.www.utils.SendEmail;
import sv.edu.udb.www.utils.Sha1;

public class ClientesModel extends Conexion {

	public int verificarTokenExistente(String tokenString) throws SQLException {
		try {
			int filasEncontradas = 0;
			String slqString = "CALL obtenerTokenExistente(?)";
			int idClienteAverificar = 0;
			this.conectar();
			cs = conexion.prepareCall(slqString);
			cs.setString(1, tokenString);
			rs = cs.executeQuery();
			if (rs.next()) {
				idClienteAverificar = rs.getInt("cliente");
				filasEncontradas++;
			}
			this.desconectar();
			if (filasEncontradas > 0) {
				activarUsuario(idClienteAverificar);
				return filasEncontradas;
			}
			return 0;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
			return 0;
		}
	}

	private void activarUsuario(int clienteID) throws SQLException {
           try {
			String sqlString = "CALL activarCliente(?,?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setInt(1, clienteID);
			cs.setInt(2, 1);
			cs.executeUpdate();
			this.desconectar();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
		}
	}

	public int registrarClientePendienteVerificaion(Clientes cliente) throws SQLException {
		try {
			Sha1 hashSha1 = new Sha1();
			int filasAfectadas = 0;
			String sqlString = "CALL insertarClientePendienteVerificacion(?,?,?,?,?,?,?,?,?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, cliente.getNombres());
			cs.setString(2, cliente.getApellidos());
			cs.setString(3, cliente.getTelefono());
			cs.setString(4, cliente.getDireccion());
			cs.setString(5, cliente.getDui());
			cs.setString(6, cliente.getEmail());
			cs.setString(7, hashSha1.sha1Hash(cliente.getPassword()));
			cs.setInt(8, 0);
			cs.setInt(9, 1);
			filasAfectadas = cs.executeUpdate();
			asignarToken(cliente.getEmail(), cliente.getNombres(), cliente.getApellidos());
			return filasAfectadas;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
			return 0;
		}
	}

	private void asignarToken(String destinatarioEmail, String nombre, String apellido) throws SQLException {
		try {
			CodigoEmpresa lastid = new CodigoEmpresa();
			SendEmail email = new SendEmail();
			String sqlString = "CALL insertarToken(?,?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setInt(1, lastid.codigoCliente());
			cs.setString(2, email.sendTokenCliente(destinatarioEmail, nombre, apellido));
			cs.executeUpdate();
			this.desconectar();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
		}
	}
}
