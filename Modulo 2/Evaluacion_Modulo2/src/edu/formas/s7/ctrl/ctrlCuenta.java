package edu.formas.s7.ctrl;

import edu.formas.s7.modelo.dao.daoAbono;
import edu.formas.s7.modelo.dao.daoCliente;
import edu.formas.s7.modelo.dao.daoCuenta;
import edu.formas.s7.modelo.entidad.Abono;
import edu.formas.s7.modelo.entidad.Cliente;
import edu.formas.s7.modelo.entidad.Cuenta;
import edu.formas.s7.vista.frmCuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ctrlCuenta implements ActionListener {

    private frmCuenta form;
    private daoCuenta dao;
    private daoCliente daoCli;
    private daoAbono daoAbono;

    public ctrlCuenta() {
        this.form = new frmCuenta();
        this.form.setControlador(this);
        this.form.setVisible(true);

        this.dao = new daoCuenta();
        this.daoCli = new daoCliente();
        this.daoAbono = new daoAbono();

        this.LlenarCuadricula();
        this.LlenarCliente();
    }

    public frmCuenta getVista() {
        return this.form;
    }

    public void LlenarCuadricula() {
        DefaultTableModel dfm = this.form.getModelo();
        dfm.setRowCount(0);
        List<Cuenta> lista = this.dao.getAll();
        for (int i = 0; i < lista.size(); i++) {
            Object fila[] = new Object[3];
            fila[0] = lista.get(i).getNumeroCuenta();
            fila[1] = lista.get(i).getCliente();
            fila[2] = lista.get(i).getSaldo(lista.get(i).getNumeroCuenta());

            dfm.addRow(fila);
        }
    }

    public void LlenarCliente() {
        List<Cliente> lista = this.daoCli.getAll();
        for (int i = 0; i < lista.size(); i++) {
            this.form.getCombo().addItem((Cliente) lista.get(i));
        }
    }
    
    public void LlenarAbonos(int cuenta){
         DefaultTableModel dfm = this.form.getModeloAbono();
        dfm.setRowCount(0);
        List<Abono> lista = this.daoAbono.getAbonosByNCuenta(cuenta);
        for (int i = 0; i < lista.size(); i++) {
            Object fila[] = new Object[4];
            fila[0] = lista.get(i).getIdAbono();
            fila[1] = lista.get(i).getNumeroCuenta();
            fila[2] = lista.get(i).getFecha();
            fila[3] = lista.get(i).getMontoAbono();

            dfm.addRow(fila);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accion = ae.getActionCommand();
      
        if (accion.equals("Aceptar")) {
            if (this.form.getAccion().equals("AD")) {
                //Agregar cuentas
                Cuenta cuenta = new Cuenta();
                Cliente cli = (Cliente) this.form.getCombo().getSelectedItem();
                cuenta.setCliente(cli);
                if (this.dao.Insertar(cuenta)) {
                    JOptionPane.showMessageDialog(this.form, "El registro se inserto con exito");
                    this.LlenarCuadricula();
                } else {
                    JOptionPane.showMessageDialog(this.form, "Hubo error en la insercion");
                }

            } else {
                DefaultTableModel mod = this.form.getModelo();
                Cuenta cnt = new Cuenta();
                Cliente cli = (Cliente) this.form.getCombo().getSelectedItem();
                cnt.setNumeroCuenta(Integer.parseInt(this.form.getTxtNumeroCuenta()));
                cnt.setCliente(cli);
                if (this.dao.Actualizar(cnt)) {
                    JOptionPane.showMessageDialog(this.form, "La actualizacon se ejecuto con exito");
                    this.LlenarCuadricula();
                } else {
                    JOptionPane.showMessageDialog(this.form, "Hubo un error en la actualizacon");
                }
            }
        }
        if (accion.equals("Eliminar")) {
            int pos = this.form.registroSeleccionado();
            if (pos >= 0) {
                int id = Integer.parseInt(this.form.getModelo().getValueAt(pos, 0).toString());

                if (this.daoAbono.EliminarByNCuenta(id)&&this.dao.Eliminar(id)) {
                    JOptionPane.showMessageDialog(this.form, "La eliminacion se ejecuto con exito");
                    this.LlenarCuadricula();
                } else {
                    JOptionPane.showMessageDialog(this.form, "Hubo un error en la eliminacion");
                }
            } else {
                JOptionPane.showMessageDialog(this.form, "No selecciono ningun cliente");
            }
        }
        if (accion.equals("AgregarAbono")) {
            Abono abono = new Abono();
            abono.setNumeroCuenta(Integer.parseInt(this.form.getTxtNCuentaAbono()));
            abono.setFecha(this.form.getTxtFechaAbono());
            abono.setMontoAbono(Float.parseFloat(this.form.getTxtMontoAbono()));
           
            if (this.daoAbono.Insertar(abono)) {
                JOptionPane.showMessageDialog(this.form, "El registro se inserto con exito");
                this.LlenarCuadricula();
                
            } else {
                JOptionPane.showMessageDialog(this.form, "Hubo error en la insercion");
            }
        } if(accion.equals("VerAbonos")){
            int pos = this.form.registroSeleccionado();
            if(pos>=0){
              int cuenta = Integer.parseInt(this.form.getModelo().getValueAt(pos, 0).toString());  
              this.LlenarAbonos(cuenta);
            }  
        }
            
            
        }

    }


