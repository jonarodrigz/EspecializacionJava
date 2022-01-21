
package edu.formas.s8.evaluacion;


public class Persona {
    private int id;
    private String Nombre;
    private String Apellido;

    public Persona() {
    }

    public Persona(int id, String Nombre, String Apellido) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public int getId() {
        return id;
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
