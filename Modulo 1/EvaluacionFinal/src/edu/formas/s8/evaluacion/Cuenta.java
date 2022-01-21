package edu.formas.s8.evaluacion;

import java.util.ArrayList;


public class Cuenta {
    private int numeroCuenta;
    private Cliente cliente;
    private ArrayList<Abonos> lstabonos;
    private float saldo;

    public Cuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.lstabonos = new ArrayList<>();
        
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        
    }public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Abonos> getAbonos() {
        return lstabonos;
    }

    public void addAbonos(Abonos abonos) {
        this.lstabonos.add(abonos);
        this.saldo += abonos.getMonto();
    }

    public float consultarSaldo() {
       
        return saldo;
    }

       
    
    
}
