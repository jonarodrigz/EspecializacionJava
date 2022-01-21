
package controlador;

import clientServices.wsCProductos;
import entidad.Productos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;
import javax.ws.rs.core.Request;
import org.primefaces.context.RequestContext;


@Named(value = "mBProductos")
@ViewScoped
public class MBProductos implements Serializable{
    private wsCProductos servicioweb;
    private List<Productos> listPro;
    private Productos productoSeleccionado;
    private int accion;
   
    public MBProductos() {
        this.servicioweb = new wsCProductos();
        this.listPro = new ArrayList<>();
        this.listPro = servicioweb.getAll();
       this.accion = 0;
    }
    
        
    public List<Productos> getListPro(){
        return this.listPro;
    }
    
    public void nuevo(){
         this.productoSeleccionado = new Productos();
         this.accion = 1;
         System.out.println("Entro al metodo nuevo");
    }
    
    public void cancelar(){
        this.productoSeleccionado = null;
    }
    
    public void guardar(){
        System.out.println("La accion es" + this.accion);
        if(this.accion == 1){
            insertar(this.productoSeleccionado);
            this.listPro.add(productoSeleccionado);
            RequestContext.getCurrentInstance().update("form:dtProducto");
        }
        else{
            actualizar(this.productoSeleccionado);
            RequestContext.getCurrentInstance().update("form:dtProducto");
        }
        RequestContext.getCurrentInstance().execute("PF('DialogoProducto').hide()");
        this.accion = 0;
    }
    
    public void insertar(Productos p){
         this.servicioweb.insertar(p);
    }
    
    public void actualizar(Productos p){
        this.servicioweb.actualizar(p);
    }
    
    public void eliminar(Integer id){
        this.servicioweb.eliminar(id);
        this.listPro.remove(productoSeleccionado);
        RequestContext.getCurrentInstance().update("form:dtProducto");
    }

    public Productos getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(Productos productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }
    
}
