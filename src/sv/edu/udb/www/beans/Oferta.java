package sv.edu.udb.www.beans;

import java.sql.Date;

public class Oferta {
	private int idOferta;
	private int idEmpresaOferta;
	private String nombreEmpresa;
	private String tituloOferta;
	private String descripcionOferta;
	private double precioRegularOferta;
	private double precio_ofertaOferta;
	private Date fechaInicioOferta;
	private Date fechaFinOferta;
	private int cantidadCuponesOferta;
	private String extrasOferta;
	private String observacionesOferta;
	private Date fechaRegistroOferta;
	private int estadoOferta;
    private double precioXcupon;
	
	
	public Oferta() {
		this.precioXcupon = 0.0;
		this.idOferta= 0;
		this.idEmpresaOferta = 0;
		this.tituloOferta = "";
		this.descripcionOferta = "";
		this.precioRegularOferta = 0.0;
		this.precio_ofertaOferta = 0.0;
		this.fechaInicioOferta = null;
		this.fechaFinOferta = null;
		this.cantidadCuponesOferta = 0;
		this.extrasOferta = "";
		this.observacionesOferta = "";
		this.fechaRegistroOferta = null;
		this.estadoOferta = 0;
	}

	public Oferta(double precioXcupon, int idEmpresaOferta, String tituloOferta, String descripcionOferta, double precioRegularOferta,
			double precio_ofertaOferta, Date fechaInicioOferta, Date fechaFinOferta, int cantidadCuponesOferta,
			String extrasOferta, String observacionesOferta, Date fechaRegistroOferta, int estadoOferta) {
		this.precioXcupon = precioXcupon;
		this.idEmpresaOferta = idEmpresaOferta;
		this.tituloOferta = tituloOferta;
		this.descripcionOferta = descripcionOferta;
		this.precioRegularOferta = precioRegularOferta;
		this.precio_ofertaOferta = precio_ofertaOferta;
		this.fechaInicioOferta = fechaInicioOferta;
		this.fechaFinOferta = fechaFinOferta;
		this.cantidadCuponesOferta = cantidadCuponesOferta;
		this.extrasOferta = extrasOferta;
		this.observacionesOferta = observacionesOferta;
		this.fechaRegistroOferta = fechaRegistroOferta;
		this.estadoOferta = estadoOferta;
	}
	
	
	
	
	public double getPrecioXcupon() {
		return precioXcupon;
	}

	public void setPrecioXcupon(double precioXcupon) {
		this.precioXcupon = precioXcupon;
	}

	public int getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}

	public int getIdEmpresaOferta() {
		return idEmpresaOferta;
	}

	public void setIdEmpresaOferta(int idEmpresaOferta) {
		this.idEmpresaOferta = idEmpresaOferta;
	}
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTituloOferta() {
		return tituloOferta;
	}

	public void setTituloOferta(String tituloOferta) {
		this.tituloOferta = tituloOferta;
	}

	public String getDescripcionOferta() {
		return descripcionOferta;
	}

	public void setDescripcionOferta(String descripcionOferta) {
		this.descripcionOferta = descripcionOferta;
	}

	public double getPrecioRegularOferta() {
		return precioRegularOferta;
	}

	public void setPrecioRegularOferta(double precioRegularOferta) {
		this.precioRegularOferta = precioRegularOferta;
	}

	public double getPrecio_ofertaOferta() {
		return precio_ofertaOferta;
	}

	public void setPrecio_ofertaOferta(double precio_ofertaOferta) {
		this.precio_ofertaOferta = precio_ofertaOferta;
	}

	public Date getFechaInicioOferta() {
		return fechaInicioOferta;
	}

	public void setFechaInicioOferta(Date fechaInicioOferta) {
		this.fechaInicioOferta = fechaInicioOferta;
	}

	public Date getFechaFinOferta() {
		return fechaFinOferta;
	}

	public void setFechaFinOferta(Date fechaFinOferta) {
		this.fechaFinOferta = fechaFinOferta;
	}

	public int getCantidadCuponesOferta() {
		return cantidadCuponesOferta;
	}

	public void setCantidadCuponesOferta(int cantidadCuponesOferta) {
		this.cantidadCuponesOferta = cantidadCuponesOferta;
	}

	public String getExtrasOferta() {
		return extrasOferta;
	}

	public void setExtrasOferta(String extrasOferta) {
		this.extrasOferta = extrasOferta;
	}

	public String getObservacionesOferta() {
		return observacionesOferta;
	}

	public void setObservacionesOferta(String observacionesOferta) {
		this.observacionesOferta = observacionesOferta;
	}

	public Date getFechaRegistroOferta() {
		return fechaRegistroOferta;
	}

	public void setFechaRegistroOferta(Date fechaRegistroOferta) {
		this.fechaRegistroOferta = fechaRegistroOferta;
	}

	public int getEstadoOferta() {
		return estadoOferta;
	}

	public void setEstadoOferta(int estadoOferta) {
		this.estadoOferta = estadoOferta;
	}

}
