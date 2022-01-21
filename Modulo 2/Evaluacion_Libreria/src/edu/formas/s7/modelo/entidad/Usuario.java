package edu.formas.s7.modelo.entidad;

public class Usuario {
     private String login;
    private String nombre;
    private String apellido;
    private String clave;

    public Usuario() {
    }

    public Usuario(String login, String nombre, String apellido, String clave) {
        this.login = login;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
