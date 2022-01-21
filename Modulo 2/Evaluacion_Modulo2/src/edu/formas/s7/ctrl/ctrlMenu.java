package edu.formas.s7.ctrl;

import edu.formas.s7.vista.frmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlMenu implements ActionListener{
  private frmMenu form;
    public ctrlMenu(){
        this.form = new frmMenu();
        this.form.setControlador(this);
        this.form.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String accion = ae.getActionCommand();
        if (accion.equals("Cliente")){
            ctrlCliente ctrl = new ctrlCliente();
            this.form.getPane().add(ctrl.getVista());
            //JOptionPane.showMessageDialog(this.form, "Se invocara al controlador del cliente");
        }
        if(accion.equals("Cuenta")){
            ctrlCuenta ctrl = new ctrlCuenta();
            this.form.getPane().add(ctrl.getVista());
        }
        if(accion.equals("Salir")){
            this.form.dispose();
        }
    }
}
