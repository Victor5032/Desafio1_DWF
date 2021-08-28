package sv.edu.udb.www.beans;

import java.sql.Date;

public class Clientes {
	private int clienteID;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String direccion;
	private String dui;
	private String email;
	private String password;
	private int estadoVerificacion;
	private Date fechaRegistro;
	private int estado;

	public Clientes() {
		this.clienteID = 0;
		this.nombres = "";
		this.apellidos = "";
		this.telefono = "";
		this.direccion = "";
		this.dui = "";
		this.email = "";
		this.password = "";
		this.estadoVerificacion = 0;
		this.fechaRegistro = null;
		this.estado = 0;
	}

	public Clientes(int clienteID, String nombres, String apellidos, String telefono, String direccion, String dui,
			String email, String password, int estadoVerificacion, Date fechaRegistro, int estado) {
		this.clienteID = clienteID;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.dui = dui;
		this.email = email;
		this.password = password;
		this.estadoVerificacion = estadoVerificacion;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}

	public int getClienteID() {
		return clienteID;
	}

	public void setClienteID(int clienteID) {
		this.clienteID = clienteID;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEstadoVerificacion() {
		return estadoVerificacion;
	}

	public void setEstadoVerificacion(int estadoVerificacion) {
		this.estadoVerificacion = estadoVerificacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	
	
}
