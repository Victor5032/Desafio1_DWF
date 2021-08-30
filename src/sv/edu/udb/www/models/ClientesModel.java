package sv.edu.udb.www.models;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.apache.tomcat.jdbc.pool.interceptor.SlowQueryReport;

import java.util.*;

import sv.edu.udb.www.beans.ClienteCupon;
import sv.edu.udb.www.beans.Clientes;
import sv.edu.udb.www.db.Conexion;
import sv.edu.udb.www.utils.CodigoEmpresa;
import sv.edu.udb.www.utils.SendEmail;
import sv.edu.udb.www.utils.Sha1;

public class ClientesModel extends Conexion {
	
	public int actualPasswordExist(String actualPassword , int clienteID) throws SQLException {
		try {
			Sha1 getSha1 = new Sha1();
			int filasObtenidas = 0;
			String sqlString = "SELECT clientes.cliente_id from `clientes` WHERE clientes.password = (?) and clientes.cliente_id = ? ";
			this.desconectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, getSha1.sha1Hash(actualPassword));
			cs.setInt(2, clienteID);
			rs = cs.executeQuery();
			if(rs.next()) {
				filasObtenidas ++ ;
			}
			this.desconectar();
			return filasObtenidas;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
			return 0;
		}
	}
	
	public int updatedPassword(String nuevoPassword, int clienteID) throws SQLException {
		try {
			int filasAfectadas = 0;
			Sha1 getSha1 = new Sha1();
			String sqlString = "UPDATE `clientes` SET `password`= (?) WHERE clientes.cliente_id = (?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, getSha1.sha1Hash(nuevoPassword));
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
	
	
	public int UpdateClient(Clientes miCliente, int clienteID) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sqlString = "UPDATE `clientes` SET `nombres`= (?) ,`apellidos`= (?) ,`telefono`= (?) ,`direccion`= (?) ,`dui`= (?) ,`email`= (?) WHERE clientes.cliente_id = ? ";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, miCliente.getNombres());
			cs.setString(2, miCliente.getApellidos());
			cs.setString(3, miCliente.getTelefono());
            cs.setString(4, miCliente.getDireccion());
            cs.setString(5, miCliente.getDui());
            cs.setString(6, miCliente.getEmail());
            cs.setInt(7, clienteID);
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

	public Clientes obtenerClientePerfil(int idCliente) throws SQLException {
		try {
			Clientes miCliente = new Clientes();
			String sqlString = "SELECT * FROM `clientes` WHERE clientes.cliente_id = ?";
			cs = conexion.prepareCall(sqlString);
			cs.setInt(1, idCliente);
			rs = cs.executeQuery();
			if (rs.next()) {
				miCliente.setNombres(rs.getString("nombres"));
				miCliente.setApellidos(rs.getString("apellidos"));
				miCliente.setDireccion(rs.getString("direccion"));
				miCliente.setTelefono(rs.getString("telefono"));
				miCliente.setDui(rs.getString("dui"));
				miCliente.setEmail(rs.getString("email"));
				return miCliente;
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
			return null;
		}
	}

	public List<ClienteCupon> cuponesDeUncliente(int clienteId) throws SQLException {
		try {
			List<ClienteCupon> misCupones = new ArrayList<ClienteCupon>();
			String sqlString = "SELECT cliente_cupones.cliente_id , cliente_cupones.cupon_id,cliente_cupones.fecha_compra, cupones.cupon_id, cupones.codigo_promocional,  cupones.estado, cupones.oferta_id, ofertas.oferta_id, ofertas.titulo, ofertas.descripcion, ofertas.precio_regular, ofertas.precio_oferta from cliente_cupones INNER JOIN cupones on cliente_cupones.cupon_id = cupones.cupon_id INNER JOIN ofertas on cupones.oferta_id = ofertas.oferta_id WHERE cliente_cupones.cliente_id = ? ORDER BY `cliente_cupones`.`fecha_compra` DESC";
            this.conectar();
            cs = conexion.prepareCall(sqlString);
            cs.setInt(1, clienteId);
            rs = cs.executeQuery();
            while(rs.next()) {
            	ClienteCupon cuponesComprados = new ClienteCupon();
            	cuponesComprados.setTituloClienteCupon(rs.getString( "titulo"));
            	cuponesComprados.setDescripcionClienteCupon( rs.getString("descripcion"));
            	cuponesComprados.setPrecioRegular(rs.getDouble("precio_regular"));
            	cuponesComprados.setPrecioOferta(rs.getDouble("precio_oferta"));
            	cuponesComprados.setFechaCompraDate(rs.getDate("fecha_compra"));
            	cuponesComprados.setEstadoCupon(rs.getInt("estado"));
            	cuponesComprados.setCodigoCupon(rs.getString("codigo_promocional"));
            	misCupones.add(cuponesComprados);
            }
			return misCupones;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(ClientesModel.class.getName()).log(Level.SEVERE, null, e);
			this.desconectar();
			return null;
		}
	}

	public int verificarCorreoNoExiste(String emailCliente) throws SQLException {
		try {
			int filasObtenidas = 1;
			String sqlString = "CALL validarCorreoExistenteCliente(?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, emailCliente);
			rs = cs.executeQuery();
			if (rs.next()) {
				filasObtenidas = 0;
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

	public int correoArecuperarExist(String correoCliente) throws SQLException {
		try {
			int clienteAsociado = 0;
			String sqlString = "CALL correoClienteExistente(?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, correoCliente);
			rs = cs.executeQuery();
			if (rs.next()) {
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

	public Clientes iniciarSesion(String correo, String password) throws SQLException {
		try {
			Sha1 getSha1 = new Sha1();
			Clientes miCliente = new Clientes();
			String sqlString = "CALL loginCliente(?,?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, getSha1.sha1Hash(password));
			cs.setString(2, correo);
			rs = cs.executeQuery();
			if (rs.next()) {
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
