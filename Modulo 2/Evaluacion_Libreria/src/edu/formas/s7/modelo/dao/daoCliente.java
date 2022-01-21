package edu.formas.s7.modelo.dao;

import edu.formas.s7.modelo.dominio.operacionesBD;
import edu.formas.s7.modelo.entidad.Cliente;
import java.util.ArrayList;
import java.util.List;

public class daoCliente {
     private operacionesBD op;
     private Cliente cli2 = new Cliente();
     
    public daoCliente(){
        this.op = new operacionesBD();
    }
    public List<Cliente> getAll(){
        String sql = "SELECT Id, nombre, apellido, documento, tipoDoc, tipoCliente FROM Cliente";
        List<Cliente> lstCliente = new ArrayList();
        List<Object[]> lstGeneral = this.op.consultarBD(sql);
        for (int i=0;i<lstGeneral.size();i++){
            Object fila[] = lstGeneral.get(i);
            Cliente cli = new Cliente((Integer) fila[0], (String) fila[1], (String) fila[2],
                    (String) fila[3],(String) fila[4],(String) fila[5]);
         
            lstCliente.add(cli);
        }
        return lstCliente;
    }
    
    public boolean Insertar(Cliente cli){
        boolean r = false;
        String sql = "INSERT INTO Cliente (Nombre, Apellido, Documento, tipoDoc, tipoCliente)"
                + " values ('" + cli.getNombre() +"','" + cli.getApellido() + "','"+ cli.getDocumento()+ "','"
                + cli.getTipoDocumento() +"','"+cli.getTipoCliente()+ "')";
        r = this.op.ejecutarSQL(sql);
        return r;
    }
    public boolean Actualizar(Cliente cli){
        boolean r = false;
        String sql = "UPDATE Cliente SET Nombre='" + cli.getNombre() + "', Apellido='" + 
                cli.getApellido() +"', Documento='"+cli.getDocumento()+"', tipoDoc='"+
                cli.getTipoDocumento()+"', tipoCliente='"+cli.getTipoCliente()+ "' WHERE Id=" + cli.getIdCliente();
        r = this.op.ejecutarSQL(sql);
        return r;
    }
    public boolean Eliminar(int id){
        boolean r = false;
        String sql = "DELETE FROM Cliente WHERE Id=" + id;
        r = this.op.ejecutarSQL(sql);
        return r;
    }
    
    public Cliente getClienteById(int id){
        Cliente cliente = null;
        String sql = "SELECT Id, nombre, apellido, documento, tipoDoc, tipoCliente FROM Cliente WHERE "
                + "Id="+id;
        List<Object[]> lstGeneral = this.op.consultarBD(sql);
        for(int i=0; i<lstGeneral.size(); i++){
             Object fila[] = lstGeneral.get(i);
           cliente = new Cliente((Integer) fila[0], (String) fila[1], (String) fila[2],
                    (String) fila[3],(String) fila[4],(String) fila[5]);
        }
        return cliente;
    }
}
