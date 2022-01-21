package edu.formas.s7.modelo.entidad;

import edu.formas.s7.modelo.dao.daoAbono;
import java.util.List;

public class Cuenta {
    private int numeroCuenta;
    private Cliente cli;
    private float saldo;
    private daoAbono abono;

    public Cuenta() {
    }

    public Cuenta(int numeroCuenta, Cliente cli) {
        this.numeroCuenta = numeroCuenta;
        this.cli = cli;
        
        this.abono = new daoAbono();
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Cliente getCliente() {
        return this.cli;
    }

    public void setCliente(Cliente cli) {
        this.cli = cli;
    }

    public float getSaldo(int numeroCuenta) {
        List<Abono> abonos = this.abono.getAbonosByNCuenta(numeroCuenta);
        for(int i=0; i<abonos.size();i++){
            this.saldo += abonos.get(i).getMontoAbono();
        }
        return saldo;
    }

   
    
}
