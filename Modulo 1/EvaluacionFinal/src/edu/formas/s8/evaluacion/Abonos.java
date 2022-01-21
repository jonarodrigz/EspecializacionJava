package edu.formas.s8.evaluacion;

public class Abonos {
    private Fecha fechaAbono;
    private float montoAbono;

    public Abonos(Fecha fechaAbono, float montoAbono) {
        this.fechaAbono = fechaAbono;
        this.montoAbono = montoAbono;
    }

    public Fecha getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(Fecha fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public float getMonto() {
        return montoAbono;
    }

    public void setMonto(float montoAbono) {
        this.montoAbono = montoAbono;
    }
    
    
    
}
