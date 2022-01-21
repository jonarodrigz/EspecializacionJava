package edu.formas.s4.modelo.entidad;

public class Cliente {
    private int idCliente;
    private String Nombre;
    private String Apellido;

    public Cliente() {
    }

    public Cliente(int idCliente, String Nombre, String Apellido) {
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
    
}
