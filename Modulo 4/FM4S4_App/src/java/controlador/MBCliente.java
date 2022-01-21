package controlador;

import clientServices.wsCCliente;
import entidad.Clientes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;


@Named(value = "mBCliente")
@ViewScoped
public class MBCliente implements Serializable{
    private wsCCliente servicioWeb;
    private List<Clientes> lstCliente;
    
    public MBCliente() {
        this.servicioWeb = new wsCCliente();
        this.lstCliente = new ArrayList<>();
        this.lstCliente = this.servicioWeb.consultarClientes();
    }
    
    public List<Clientes> getlstCliente(){
        return this.lstCliente;
    }
}
