package edu.formas.s7.modelo.entidad;

public class Abono {
        private int idAbono;
        private int numeroCuenta;
        private String fecha;
        private float montoAbono;

    public Abono() {
    }

    public Abono(int idAbono, int numeroCuenta, String fecha, float montoAbono) {
        this.idAbono = idAbono;
        this.numeroCuenta = numeroCuenta;
        this.fecha = fecha;
        this.montoAbono = montoAbono;
    }

    public int getIdAbono() {
        return idAbono;
    }

    public void setIdAbono(int idAbono) {
        this.idAbono = idAbono;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getMontoAbono() {
        return montoAbono;
    }

    public void setMontoAbono(float montoAbono) {
        this.montoAbono = montoAbono;
    }
        
        
}
