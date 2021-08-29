package sv.edu.udb.www.beans;

import java.sql.Date;

public class ClienteCupon {
	private String tituloClienteCupon;
	private String descripcionClienteCupon;
	private double precioRegular;
	private double precioOferta;
	private Date fechaCompraDate;
	private int estadoCupon;

     
	
	
	public int getEstadoCupon() {
		return estadoCupon;
	}

	public void setEstadoCupon(int estadoCupon) {
		this.estadoCupon = estadoCupon;
	}

	public String getTituloClienteCupon() {
		return tituloClienteCupon;
	}

	public void setTituloClienteCupon(String tituloClienteCupon) {
		this.tituloClienteCupon = tituloClienteCupon;
	}

	public String getDescripcionClienteCupon() {
		return descripcionClienteCupon;
	}

	public void setDescripcionClienteCupon(String descripcionClienteCupon) {
		this.descripcionClienteCupon = descripcionClienteCupon;
	}

	public double getPrecioRegular() {
		return precioRegular;
	}

	public void setPrecioRegular(double precioRegular) {
		this.precioRegular = precioRegular;
	}

	public double getPrecioOferta() {
		return precioOferta;
	}

	public void setPrecioOferta(double precioOferta) {
		this.precioOferta = precioOferta;
	}

	public Date getFechaCompraDate() {
		return fechaCompraDate;
	}

	public void setFechaCompraDate(Date fechaCompraDate) {
		this.fechaCompraDate = fechaCompraDate;
	}

}
