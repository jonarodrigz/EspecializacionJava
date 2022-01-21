package edu.formas.s8.evaluacion;


public class Fecha {
    
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = 1;
        this.mes = 1;
        this.anio = anio;
    }
    
    public String getFecha(){
        return dia + "/" + mes + "/" + anio;
               
    }
    
}
