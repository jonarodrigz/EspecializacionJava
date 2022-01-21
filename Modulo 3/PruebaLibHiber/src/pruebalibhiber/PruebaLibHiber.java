/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebalibhiber;

import edu.formas.FM3S6.modelo.dao.daoAbonos;
import edu.formas.FM3S6.modelo.dao.daoCliente;
import edu.formas.FM3S6.modelo.entidad.Abonos;
import edu.formas.FM3S6.modelo.entidad.Cliente;
import edu.formas.FM3S6.modelo.entidad.Cuenta;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PruebaLibHiber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        daoCliente dao = new daoCliente();
        daoAbonos daoA = new daoAbonos();
        List<Cliente> lst = dao.getAll();
        
        for (Cliente cliente : lst) {
            System.out.println("Nombre: "+cliente.getNombre()+" " + cliente.getApellido());
        }
        
//        Cuenta cue = new Cuenta();
//        cue.setNumeroCuenta(30);
        List<Abonos> abn = daoA.getAbonoByNCuenta(31);
        
      for (Abonos ab : abn) {
            System.out.println("Nombre: "+ab.getFechaAbono()+" " + ab.getMontoAbono());
        }
        
    }
    
}
