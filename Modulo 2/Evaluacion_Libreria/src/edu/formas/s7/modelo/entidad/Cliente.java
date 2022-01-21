package edu.formas.s7.modelo.entidad;

public class Cliente {
     private int idCliente;
     private String nombre;
     private String apellido;
     private String Documento;
     private String tipoDocumento;
     private String tipoCliente;
     

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, String Documento, String tipoDocumento, String tipoCliente) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Documento = Documento;
        this.tipoDocumento = tipoDocumento;
        this.tipoCliente = tipoCliente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

   

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

   

   
    
    
}
