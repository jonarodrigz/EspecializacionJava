
package edu.formas.s4.ejemplo;

public class Estudiante extends Persona{
    private float nota1;
    private float nota2;
    private float nota3;

    public Estudiante() {
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
    }
    
    public void setNotas(float n1, float n2, float n3){
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
    }
    
    public float getPromedio(){
        return (this.nota1+this.nota2+this.nota3)/3;
    }
    
}
