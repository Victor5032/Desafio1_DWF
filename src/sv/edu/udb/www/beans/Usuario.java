package sv.edu.udb.www.beans;

public class Usuario {
	private String nombre;
	private String apellido;
	private String usuario;
	private String correo;
	private String password;
	
	public Usuario() {
		this.nombre = "";
		this.apellido = "";
		this.usuario = "";
		this.correo = "";
		this.password = "";
	}

	public Usuario(String nombre, String apellido, String usuario, String correo, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.correo = correo;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

