package sv.edu.udb.www.beans;

import java.util.Date;

public class Cupon {
	private int cuponId;
	private int ofertaId;
	private Oferta oferta;
	private String codigoPromocional;
	private Date fechaVencimiento;
	private Date fechaRegistro;
	private int estado;
	
	public Cupon() { }

	public int getCuponId() {
		return cuponId;
	}

	public void setCuponId(int cuponId) {
		this.cuponId = cuponId;
	}

	public int getOfertaId() {
		return ofertaId;
	}

	public void setOfertaId(int ofertaId) {
		this.ofertaId = ofertaId;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public String getCodigoPromocional() {
		return codigoPromocional;
	}

	public void setCodigoPromocional(String codigoPromocional) {
		this.codigoPromocional = codigoPromocional;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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
