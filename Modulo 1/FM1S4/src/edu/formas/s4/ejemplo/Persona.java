package edu.formas.s4.ejemplo;

public class Persona {
    protected int codigo;
    protected  String nombres;
    protected String apellidos;
    protected Fecha fechaNac;

    public Persona() {
        this.codigo = 0;
       this.fechaNac = new Fecha();
    }
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getApellido() {
        return apellidos;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }
    
    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }
    
}
