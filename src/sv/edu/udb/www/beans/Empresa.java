package sv.edu.udb.www.beans;

import java.sql.Date;

public class Empresa {
    private int empresa_id;
    private String codigo_empresa;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private String contactoEmpresa;
    private String telefonoEmpresa;
    private String correoEmpresa;
    private String empresa_password;
    private int rubro_id;
    private double comisionEmpresa;
    private Date fecha_registro;
    private int estado_empresa;
    
    
    
    public Empresa() {
        this.empresa_id = 0;
        this.codigo_empresa = "";
        this.nombreEmpresa = "";
        this.direccionEmpresa = "";
        this.contactoEmpresa = "";
        this.telefonoEmpresa = "";
        this.correoEmpresa = "";
        this.empresa_password = "";
        this.rubro_id = 0;
        this.comisionEmpresa = 0.0;
        this.fecha_registro = null;
        this.estado_empresa = 0;
    }


    public Empresa(int empresa_id, String codigo_empresa, String nombreEmpresa, String direccionEmpresa, String contactoEmpresa, String telefonoEmpresa, String correoEmpresa, String empresa_password, int rubro_id, double comisionEmpresa, Date fecha_registro, int estado_empresa) {
        this.empresa_id = empresa_id;
        this.codigo_empresa = codigo_empresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.contactoEmpresa = contactoEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.correoEmpresa = correoEmpresa;
        this.empresa_password = empresa_password;
        this.rubro_id = rubro_id;
        this.comisionEmpresa = comisionEmpresa;
        this.fecha_registro = fecha_registro;
        this.estado_empresa = estado_empresa;
    }

    public int getEmpresa_id() {
        return this.empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getCodigo_empresa() {
        return this.codigo_empresa;
    }

    public void setCodigo_empresa(String codigo_empresa) {
        this.codigo_empresa = codigo_empresa;
    }

    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return this.direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getContactoEmpresa() {
        return this.contactoEmpresa;
    }

    public void setContactoEmpresa(String contactoEmpresa) {
        this.contactoEmpresa = contactoEmpresa;
    }

    public String getTelefonoEmpresa() {
        return this.telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getCorreoEmpresa() {
        return this.correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    public String getEmpresa_password() {
        return this.empresa_password;
    }

    public void setEmpresa_password(String empresa_password) {
        this.empresa_password = empresa_password;
    }

    public int getRubro_id() {
        return this.rubro_id;
    }

    public void setRubro_id(int rubro_id) {
        this.rubro_id = rubro_id;
    }

    public double getComisionEmpresa() {
        return this.comisionEmpresa;
    }

    public void setComisionEmpresa(double comisionEmpresa) {
        this.comisionEmpresa = comisionEmpresa;
    }

    public Date getFecha_registro() {
        return this.fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getEstado_empresa() {
        return this.estado_empresa;
    }

    public void setEstado_empresa(int estado_empresa) {
        this.estado_empresa = estado_empresa;
    }

}
