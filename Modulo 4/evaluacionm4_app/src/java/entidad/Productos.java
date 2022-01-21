package entidad;
// Generated 12-21-2021 06:46:02 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;



public class Productos  implements java.io.Serializable {


     private Integer idproductos;
     private String nombre;
     private Double precio;

    public Productos() {
    }

    public Productos(String nombre, Double precio) {
       this.nombre = nombre;
       this.precio = precio;
    }
     
   
    public Integer getIdproductos() {
        return this.idproductos;
    }
    
    public void setIdproductos(Integer idproductos) {
        this.idproductos = idproductos;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

       
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }




}


