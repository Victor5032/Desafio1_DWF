package sv.edu.udb.www.models;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;

import java.sql.SQLException;
import java.security.NoSuchAlgorithmException;
import sv.edu.udb.www.db.Conexion;
import sv.edu.udb.www.utils.CodigoEmpresa;
import sv.edu.udb.www.utils.SendEmail;
import sv.edu.udb.www.utils.Sha1;
import sv.edu.udb.www.beans.Empresa;

public class EmpresaModel extends Conexion {

	// Ciclo registro de empresa
	public int verificarTokenExistente(String tokenString) throws SQLException {
		try {
			int tokenExistente = 0;
			String sqlString = "CALL obtenerTokenExistente(?)";
			int idAverificar = 0;
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setString(1, tokenString);
			rs = cs.executeQuery();
			if (rs.next()) {
				idAverificar = rs.getInt("empresa");
				tokenExistente++;
			}
			this.desconectar();
			activarEmpresa(idAverificar);
			return tokenExistente;
		} catch (Exception ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaModel.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		} finally {
			this.desconectar();
		}
	}

	private void activarEmpresa(int idEmpresa) throws SQLException {
		try {
			String sqlString = "CALL activarEmpresa(?,?)";
			this.conectar();
			cs = conexion.prepareCall(sqlString);
			cs.setInt(1, 1);
			cs.setInt(2, idEmpresa);
			cs.executeUpdate();
			this.desconectar();
		} catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
		}

	}

	public int registrarEmpresaPendienteVerificaion(Empresa empresa) throws SQLException, NoSuchAlgorithmException {
		try {
			Sha1 sha1 = new Sha1();
			int filasAfectadas = 0;
			String sql = "CALL insertarEmpresa(?,?,?,?,?,?,?,?,?,?)";
			this.conectar();
			cs = conexion.prepareCall(sql);
			cs.setString(1, empresa.getCodigo_empresa());
			cs.setString(2, empresa.getNombreEmpresa());
			cs.setString(3, empresa.getDireccionEmpresa());
			cs.setString(4, empresa.getContactoEmpresa());
			cs.setString(5, empresa.getTelefonoEmpresa());
			cs.setString(6, empresa.getCorreoEmpresa());
			cs.setString(7, sha1.sha1Hash(empresa.getEmpresa_password()));
			cs.setInt(8, 1);
			cs.setDouble(9, empresa.getComisionEmpresa());
			cs.setInt(10, 3);
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			asignarToken(empresa.getCorreoEmpresa(), empresa.getNombreEmpresa());
			return filasAfectadas;
		} catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return 0;
		}
	}

	private void asignarToken(String destinatarioEmail, String nombreEmpresa) throws SQLException {
		try {
			CodigoEmpresa codigo = new CodigoEmpresa();
			SendEmail email = new SendEmail();
			String sql = "CALL insertarToken(?,?)";
			this.conectar();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, codigo.codigoEmpresaToken());
			cs.setString(2, email.sendEmpresaVerificationEmail(destinatarioEmail, nombreEmpresa));
			cs.executeUpdate();
			this.desconectar();
		} catch (SQLException | MessagingException ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
		}
	}

	public Empresa iniciarSesion(Empresa empresa) throws SQLException {
		try {
		   Empresa logEmpresa = new Empresa();
           String sqlString = "CALL loginEmpresa(?,?)";
           this.conectar();
           cs = conexion.prepareCall(sqlString);
           cs.setString(1, empresa.getCorreoEmpresa());
           cs.setString(2, empresa.getEmpresa_password());
           
           return logEmpresa;
		} catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(EmpresaModel.class.getName()).log(Level.SEVERE, null, ex);
			this.desconectar();
			return null;
		}
	}

	// Obtenemos la empresa
	public Empresa obtenerEmpresa(int idEmpresa) throws SQLException {
		try {
			String sql = "SELECT * FROM empresas WHERE empresa_id = ?";
			
			Empresa empresa = new Empresa();
			
			this.conectar();
			
			cs = conexion.prepareCall(sql);
			
			cs.setInt(1, idEmpresa);
			
			rs = cs.executeQuery();
			
			if (rs.next()) {
				empresa.setCodigo_empresa(rs.getString("codigo"));
				empresa.setNombreEmpresa(rs.getString("nombre"));

				this.desconectar();
			
				return empresa;
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
