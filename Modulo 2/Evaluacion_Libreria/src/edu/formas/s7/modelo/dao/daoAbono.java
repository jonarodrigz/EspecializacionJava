package edu.formas.s7.modelo.dao;

import edu.formas.s7.modelo.dominio.operacionesBD;
import edu.formas.s7.modelo.entidad.Abono;
import edu.formas.s7.modelo.entidad.Cuenta;
import java.util.ArrayList;
import java.util.List;

public class daoAbono {
    private operacionesBD op;
    private Abono abono = new Abono();

    public daoAbono() {
        this.op = new operacionesBD();
    }
    
    public List<Abono> getAll(){
        String sql = "SELECT idAbono, numeroCuenta, fechaAbono, montoAbono FROM abonos";
        List<Abono> lstAbono = new ArrayList();
        List<Object[]> lstGeneral = this.op.consultarBD(sql);
        for(int i=0;i<lstGeneral.size();i++){
            Object fila[] = lstGeneral.get(i);
            Abono abo = new Abono((Integer) fila[0],(Integer) fila[1],(String) fila[2], (Float) fila[3]);
            lstAbono.add(abo);
        }
        
        return lstAbono;
    }
    
    public List<Abono> getAbonosByNCuenta(int id){
        String sql = "SELECT idAbono, numeroCuenta, fechaAbono, montoAbono FROM abonos"
                + " WHERE numeroCuenta="+id;
        List<Abono> lstAbono = new ArrayList();
        List<Object[]> lstGeneral = this.op.consultarBD(sql);
        for(int i=0;i<lstGeneral.size();i++){
            Object fila[] = lstGeneral.get(i);
            Abono abo = new Abono((Integer) fila[0],(Integer) fila[1],fila[2].toString(), (Float) fila[3]);
            lstAbono.add(abo);
        }
        
        return lstAbono;
    }
    
    public boolean Insertar(Abono abono){
        boolean r = false;
        
        String sql = "INSERT INTO abonos (numeroCuenta, fechaAbono, montoAbono)"+
                "values ('"+abono.getNumeroCuenta()+"','"+abono.getFecha()+"','"+
                abono.getMontoAbono()+"')";
        r = this.op.ejecutarSQL(sql);
                
        return r;
    }
    
    public boolean Actualizar(Abono abono){
        boolean r = false;
        String sql = "UPDATE abonos SET numeroCuenta="+abono.getNumeroCuenta()+", fecha="+abono.getFecha()+
                ", montoAbono="+abono.getMontoAbono()+"WHERE numeroCuenta="+abono.getIdAbono();
        r = this.op.ejecutarSQL(sql);
                
        return r;
    }
    
    public boolean Eliminar(int idAbono){
        boolean r = false;
        String sql = "DELETE FROM Abonos WHERE idAbono=" + idAbono;
        r = this.op.ejecutarSQL(sql);
        return r;
    }
    
    public boolean EliminarByNCuenta(int numeroCuenta){
        boolean r = false;
        String sql = "DELETE FROM Abonos WHERE numeroCuenta=" + numeroCuenta;
        r = this.op.ejecutarSQL(sql);
        return r;
    }
}
