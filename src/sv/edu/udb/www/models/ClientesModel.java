package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import sv.edu.udb.www.beans.Clientes;
import sv.edu.udb.www.db.Conexion;
import sv.edu.udb.www.utils.CodigoEmpresa;
import sv.edu.udb.www.utils.SendEmail;
import sv.edu.udb.www.utils.Sha1;

public class ClientesModel extends Conexion {
	
	public int verificarCorreoNoExiste(String emailCliente) throws SQLException{
		try {
			int filasObtenidas = 1;
			String sqlString = "CALL validarCorreoExistenteCliente(?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, emailCliente);
			rs = cs.executeQuery();
			if(rs.next()) {
				filasObtenidas = 0 ;
			}
			this.desconectar();
			return filasObtenidas;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
			return 1;
		}
	}
	
	
	
	public int correoArecuperarExist(String correoCliente)throws SQLException{
		try {
			int clienteAsociado = 0;
			String sqlString = "CALL correoClienteExistente(?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, correoCliente);
			rs = cs.executeQuery();
			if(rs.next()) {
				clienteAsociado = rs.getInt("cliente_id");
			}
			this.desconectar();
			return clienteAsociado;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
			return 0;
		}
	}
	
	public int recuperarNuevoPassword(String correoCliente, int clienteID) throws SQLException {
		try {
			int filasAfectadas = 0;
			Sha1 sha1 = new Sha1();
			SendEmail mEmail = new SendEmail();
			String sqlString = "CALL recuperarPasswordCliente(?,?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			String newpasswordString = mEmail.restablecerPasswordCliente(correoCliente);
			cs.setString(1, sha1.sha1Hash(newpasswordString));
			cs.setInt(2, clienteID);
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
			return 0;
		}
	}
	
	public Clientes iniciarSesion(String correo, String password) throws SQLException{
		try {
			Sha1 getSha1 = new Sha1();
			Clientes miCliente = new Clientes();
			String sqlString = "CALL loginCliente(?,?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, getSha1.sha1Hash(password));
			cs.setString(2, correo);
			rs = cs.executeQuery();
			if(rs.next()) {
				miCliente.setClienteID(rs.getInt("cliente_id"));
				miCliente.setNombres(rs.getString("nombres"));
				miCliente.setApellidos(rs.getString("apellidos"));
				this.desconectar();
				return miCliente;
			}
			this.desconectar();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
			return null;
		}
	}
	
	
	
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
	
	public List<Clientes> listadoClientes() throws SQLException {
		ArrayList<Clientes> clientes = new ArrayList<Clientes>();
		
		String sql = "SELECT * FROM clientes WHERE estado = 1";
		
		try {
			this.conectar();

			cs = conexion.prepareCall(sql);

			rs = cs.executeQuery();

			while (rs.next()) {
				Clientes cliente = new Clientes();
				
				cliente.setClienteID(rs.getInt("cliente_id"));
				cliente.setNombres(rs.getString("nombres"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setTelefono(rs.getString("telefono"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setDui(rs.getString("dui"));
				cliente.setEmail(rs.getString("email"));
				
				clientes.add(cliente);
			}

			this.desconectar();

			return clientes;
		} catch (SQLException ex) {
			Logger.getLogger(EmpresaModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return null;
		}
	}
	
	public Clientes obtenerCliente(int id) throws SQLException {
		try {
			String sql = "SELECT * FROM clientes WHERE cliente_id = ?";

			Clientes cliente = new Clientes();

			this.conectar();

			cs = conexion.prepareCall(sql);

			cs.setInt(1, id);

			rs = cs.executeQuery();

			if (rs.next()) {
				cliente.setClienteID(rs.getInt("cliente_id"));
				cliente.setNombres(rs.getString("nombres"));
				cliente.setApellidos(rs.getString("apellidos"));
				cliente.setFechaRegistro(rs.getDate("fecha_registro"));
				cliente.setEstadoVerificacion(rs.getInt("verificacion"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setDui(rs.getString("dui"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefono(rs.getString("telefono"));

				this.desconectar();

				return cliente;
			}

			this.desconectar();

			return null;
		} catch (SQLException ex) {
			Logger.getLogger(EmpresaModel.class.getName()).log(Level.SEVERE, null, ex);

			this.desconectar();

			return null;
		}
	}
}
