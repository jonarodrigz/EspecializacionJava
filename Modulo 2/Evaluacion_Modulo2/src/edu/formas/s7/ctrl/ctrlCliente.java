package edu.formas.s7.ctrl;

import edu.formas.s7.modelo.dao.daoCliente;
import edu.formas.s7.modelo.entidad.Cliente;
import edu.formas.s7.vista.frmCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ctrlCliente implements ActionListener{
    private frmCliente form;
    private daoCliente dao;
    
    public ctrlCliente(){
        this.form = new frmCliente();
        this.form.setControlador(this);
        this.form.setVisible(true);
        
        this.dao = new daoCliente();
        this.LlenarCuadricula();
    }
    
    public frmCliente getVista(){
        return this.form;
    }
    
    private void LlenarCuadricula(){
        DefaultTableModel dfm = this.form.getModelo();
        dfm.setRowCount(0);
        List<Cliente> lista = this.dao.getAll();
        for (int i=0; i<lista.size();i++){
            Object fila[] = new Object[6];
            fila[0] = lista.get(i).getIdCliente();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getApellido();
            fila[3] = lista.get(i).getDocumento();
            fila[4] = lista.get(i).getTipoDocumento();
            fila[5] = lista.get(i).getTipoCliente();
            dfm.addRow(fila);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
         String accion = ae.getActionCommand();
        if (accion.equals("Aceptar")){
            if (this.form.getAccion().equals("AD")){
                //Agregar cliente
                Cliente cli = new Cliente();
                cli.setNombre(this.form.getTxtNombre());
                cli.setApellido(this.form.getTxtApellido());
                cli.setDocumento(this.form.getTxtDocumento());
                cli.setTipoDocumento(this.form.getTipoDocumento());
                cli.setTipoCliente(this.form.getTipoCliente());
                if (this.dao.Insertar(cli)){
                    JOptionPane.showMessageDialog(this.form, "El registro se inserto con exito");
                    this.LlenarCuadricula();
                }
                else
                    JOptionPane.showMessageDialog(this.form, "Hubo error en la insercion");
            }
            else{
                //Modificar
                DefaultTableModel mod = this.form.getModelo();
                Cliente cli = new Cliente();
                cli.setIdCliente(Integer.parseInt(this.form.getTxtId()));
                cli.setNombre(this.form.getTxtNombre());
                cli.setApellido(this.form.getTxtApellido());
                cli.setDocumento(this.form.getTxtDocumento());
                cli.setTipoDocumento(this.form.getTipoDocumento());
                cli.setTipoCliente(this.form.getTipoCliente());
                if (this.dao.Actualizar(cli)){
                    JOptionPane.showMessageDialog(this.form, "La actualizacon se ejecuto con exito");
                    this.LlenarCuadricula();
                }
                else{
                    JOptionPane.showMessageDialog(this.form, "Hubo un error en la actualizacon");
                }
            }
        }
        else{
            //Eliminar
            if (accion.equals("Eliminar")){
                int pos = this.form.registroSeleccionado();
                if (pos >=0){
                    int id = Integer.parseInt(this.form.getModelo().getValueAt(pos, 0).toString());
                    
                    if (this.dao.Eliminar(id)){
                        JOptionPane.showMessageDialog(this.form, "La eliminacion se ejecuto con exito");
                        this.LlenarCuadricula();
                    }
                    else{
                        JOptionPane.showMessageDialog(this.form, "Hubo un error en la eliminacion");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this.form, "No selecciono ningun cliente");
                }
            }
        }
     }
    
}
