
package edu.formas.s8.evaluacion;


public abstract class Cliente extends Persona{
    protected String documento;

    public Cliente() {
    }

    public Cliente(int id, String Nombre, String Apellido) {
        super(id, Nombre, Apellido);
    }

  
    public abstract int getTipoCliente();
    
}
