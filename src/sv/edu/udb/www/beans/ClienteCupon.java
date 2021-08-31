package sv.edu.udb.www.beans;

import java.sql.Date;

public class ClienteCupon {
	private String tituloClienteCupon;
	private String descripcionClienteCupon;
	private double precioRegular;
	private double precioOferta;
	private Date fechaCompraDate;
	private int estadoCupon;
	private String estado;
	private String codigoCupon;
	private Date fechaVencimiento;
	private String cliente;
	private String dui;

	public String getCodigoCupon() {
		return codigoCupon;
	}

	public void setCodigoCupon(String codigoCupon) {
		this.codigoCupon = codigoCupon;
	}
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

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
	
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}
}
