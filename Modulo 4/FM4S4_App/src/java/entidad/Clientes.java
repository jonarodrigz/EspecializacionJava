package entidad;
// Generated 12-02-2021 06:25:30 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;

public class Clientes implements java.io.Serializable {

    private Integer idclientes;
    private String nombre;
    private String apellido;

    public Clientes() {
    }

    public Clientes(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdclientes() {
        return this.idclientes;
    }

    public void setIdclientes(Integer idclientes) {
        this.idclientes = idclientes;
    }

    @Column(name = "nombre", length = 45)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "apellido", length = 45)
    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
