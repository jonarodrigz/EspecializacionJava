package edu.formas.s4.modelo.dao;

import edu.formas.s4.modelo.dominio.operacionesBD;
import edu.formas.s4.modelo.entidad.Cliente;
import java.util.ArrayList;
import java.util.List;

public class daoCliente {
    private operacionesBD op;

    public daoCliente() {
        this.op = new operacionesBD();
    }
    
    public List<Cliente> getAll(){
        String sql="Select idCliente, Nombre, Apellido FROM Cliente";
        List <Cliente> lstCliente = new ArrayList();
        List<Object[]> lstGeneral = this.op.consultarBD(sql);
      
        for(int i=0; i<lstGeneral.size();i++){
            Object fila[] = lstGeneral.get(i);
            Cliente cli = new Cliente((Integer)fila[0], (String)fila[1], (String)fila[2]);
            lstCliente.add(cli);
        }
        return lstCliente;
    }
    
    
}
