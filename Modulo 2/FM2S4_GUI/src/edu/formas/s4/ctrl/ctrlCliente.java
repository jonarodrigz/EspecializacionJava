package edu.formas.s4.ctrl;

import edu.formas.s4.modelo.dao.daoCliente;
import edu.formas.s4.modelo.entidad.Cliente;
import edu.formas.s4.vista.frmCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ctrlCliente implements ActionListener{
    private frmCliente form;
    private daoCliente dao;
    
    public ctrlCliente(){
        this.form = new frmCliente();
        this.form.setControlador(this);
        this.form.setVisible(true);
        
        this.dao = new daoCliente();
        this.llenarCuadricula();
        
    }
    
    private void llenarCuadricula(){
        DefaultTableModel dfm = this.form.getModelo();
        
        List<Cliente> lista = this.dao.getAll();
        for (int i = 0; i < lista.size(); i++) {
            Object fila[] = new Object[3];
            fila[0]=lista.get(i).getIdCliente();
            fila[1]=lista.get(i).getNombre();
            fila[2]=lista.get(i).getApellido();
            dfm.addRow(fila);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accion = ae.getActionCommand();
        if(accion.equals("Aceptar")){
                                                                                                                    
        }
    }
    
    
}
