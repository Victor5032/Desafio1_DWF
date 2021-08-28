package sv.edu.udb.www.utils;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sv.edu.udb.www.db.Conexion;

public class CodigoEmpresa extends Conexion{
    public String nuevoCodigoEmpresa() throws SQLException {
    	try {
			String codigoEmpresaString = "EMP";
			int total = 0;
			String sql = "SELECT COUNT(codigo) as totalEMP FROM empresas;";
			this.conectar();
			st = conexion.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				total = rs.getInt("totalEMP");
			}
			if(total == 100) {
				codigoEmpresaString += String.valueOf(total + 1); 
			}else if(total == 99) {
				codigoEmpresaString += String.valueOf(total + 1);
			}else if(total > 98) {
				codigoEmpresaString +="0"+ String.valueOf(total + 1);
			}else if(total == 10) {
				codigoEmpresaString +="0"+ String.valueOf(total + 1);
				
			}else if(total == 9) {
				codigoEmpresaString +="0"+ String.valueOf(total + 1);
			}else if(total < 9){
				codigoEmpresaString +="00"+ String.valueOf(total + 1);
			}
			this.desconectar();
			return codigoEmpresaString;
		} catch (SQLException ex) {
			// TODO: handle exception
			Logger.getLogger(CodigoEmpresa.class.getName()).log(Level.SEVERE, null, ex);
			return "";
		}finally {
			this.desconectar();
		}
    }
    
    public int codigoEmpresaToken() throws SQLException{
    	try {
			int codigoEmpresaActual = 0;
			String sqlString ="select empresas.empresa_id as codigo from empresas ORDER BY empresas.empresa_id DESC LIMIT 1";
			this.conectar();
			st = conexion.prepareStatement(sqlString);
			rs = st.executeQuery();
			while(rs.next()) {
				codigoEmpresaActual = Integer.valueOf(rs.getInt("codigo")); 
			}
			this.desconectar();
			return codigoEmpresaActual;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CodigoEmpresa.class.getName()).log(Level.SEVERE, null, e);
			return  0;
		}finally {
			this.desconectar();
		}
    }
    public int codigoCliente() throws SQLException{
    	try {
			int codigoEmpresaActual = 0;
			String sqlString ="select clientes.cliente_id as codigo from clientes ORDER BY clientes.cliente_id DESC LIMIT 1";
			this.conectar();
			st = conexion.prepareStatement(sqlString);
			rs = st.executeQuery();
			while(rs.next()) {
				codigoEmpresaActual = Integer.valueOf(rs.getInt("codigo")); 
			}
			this.desconectar();
			return codigoEmpresaActual;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(CodigoEmpresa.class.getName()).log(Level.SEVERE, null, e);
			return  0;
		}finally {
			this.desconectar();
		}
    }
}
