package sv.edu.udb.www.beans;

import java.sql.Date;

public class Rubro {
	private int rubroID;
	private String rubro;
	private Date fecha_registro;
	private int estado;

	public Rubro() {
		this.rubroID = 0;
		this.rubro = "";
		this.fecha_registro = null;
		this.estado = 0;
	}

	public Rubro(int rubroID, String rubro, Date fecha_registro, int estado) {

		this.rubro = rubro;
		this.fecha_registro = fecha_registro;
		this.estado = estado;
	}

	public int getRubroID() {
		return rubroID;
	}

	public void setRubroID(int rubroID) {
		this.rubroID = rubroID;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
