package edu.formas.s7.modelo.dao;

import edu.formas.s7.modelo.dominio.operacionesBD;
import edu.formas.s7.modelo.entidad.Cliente;
import edu.formas.s7.modelo.entidad.Cuenta;
import java.util.ArrayList;
import java.util.List;

public class daoCuenta {
    private operacionesBD op;
    private Cuenta cuenta = new Cuenta();
    private daoCliente dao;
    
    public daoCuenta(){
        this.op = new operacionesBD();
        this.dao = new daoCliente();
    }
    
    public List<Cuenta> getAll(){
        String sql = "SELECT numeroCuenta, idCliente, saldo FROM cuenta";
        List<Cuenta> lstCuenta = new ArrayList();
        List<Object[]> lstGeneral = this.op.consultarBD(sql);
        for(int i=0;i<lstGeneral.size();i++){
            Object fila[] = lstGeneral.get(i);
            Cliente cli = dao.getClienteById((Integer) fila[1]);
            Cuenta cnt = new Cuenta((Integer) fila[0],cli);
            lstCuenta.add(cnt);
        }
        
        return lstCuenta;
    }
    
    public boolean Insertar(Cuenta cuenta){
        boolean r = false;
        String sql = "INSERT INTO Cuenta (idCliente)"+
                "values ('"+cuenta.getCliente().getIdCliente()+"')";
        r = this.op.ejecutarSQL(sql);
                
        return r;
    }
    
    public boolean Actualizar(Cuenta cuenta){
        boolean r = false;
        String sql = "UPDATE Cuenta SET idCliente="+cuenta.getCliente().getIdCliente()+
                " WHERE numeroCuenta="+cuenta.getNumeroCuenta();
        r = this.op.ejecutarSQL(sql);
                
        return r;
    }
    
    public boolean Eliminar(int numeroC){
        boolean r = false;
        String sql = "DELETE FROM Cuenta WHERE numeroCuenta=" + numeroC;
        r = this.op.ejecutarSQL(sql);
        return r;
    }
}
