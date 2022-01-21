package edu.formas.s7.ctrl;

import edu.formas.s7.modelo.dao.daoUsuario;
import edu.formas.s7.modelo.entidad.Usuario;
import edu.formas.s7.vista.frmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlLogin implements ActionListener{
    private frmLogin form;
    private daoUsuario dao;
    public ctrlLogin(){
        this.dao = new daoUsuario();
        this.form = new frmLogin();
        this.form.setControlador(this);
        this.form.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
             String accion = ae.getActionCommand();
        if (accion.equals("Aceptar")){
            String login, clave;
            login = this.form.getLogin();
            clave = this.form.getClave();
            Usuario usr = this.dao.login(login, clave);
          
            if (usr.getLogin()==null || usr.getLogin().equals("")){
                JOptionPane.showMessageDialog(this.form, "Error en el usuario o clave");
            }
            else{
               // JOptionPane.showMessageDialog(this.form, "Datos validos");
                ctrlMenu ctrl = new ctrlMenu();
                this.form.setVisible(false);
                this.form.dispose();
            }
        }
        if (accion.equals("Salir")){
            this.form.dispose();
        }
    }
    }
    

