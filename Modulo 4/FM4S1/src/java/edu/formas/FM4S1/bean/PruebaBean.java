
package edu.formas.FM4S1.bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Usuario
 */
@Named(value = "pruebaBean")
@ViewScoped
public class PruebaBean implements Serializable{
    private boolean estado;
    private int op1;
    private int op2;
    private int r;
    private ArrayList<Integer> lista;
      
    public PruebaBean() {
        this.estado = true;
        this.op1 = 0;
        this.op2= 0;
        this.r = 0;
        this.lista = new ArrayList<>();
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getOp1() {
        return op1;
    }

    public void setOp1(int op1) {
        this.op1 = op1;
    }

    public int getOp2() {
        return op2;
    }

    public void setOp2(int op2) {
        this.op2 = op2;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
    
    public void Suma(){
        this.r = this.op1 + this.op2;
        this.estado = false;
        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El resultado es: "+this.r, null);
        FacesContext.getCurrentInstance().addMessage("componetForm:resultado", msg1);
        this.lista.add(this.r);
    }
    public void Agregar(){
        this.estado = true;
    }
}
