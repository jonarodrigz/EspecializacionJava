package modelo.entidad;
// Generated 12-21-2021 06:46:02 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Productos generated by hbm2java
 */
@Entity
@Table(name="productos"
    ,catalog="evaluacionm4"
)
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
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idproductos", unique=true, nullable=false)
    public Integer getIdproductos() {
        return this.idproductos;
    }
    
    public void setIdproductos(Integer idproductos) {
        this.idproductos = idproductos;
    }

    
    @Column(name="nombre", length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="precio", precision=5)
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }




}


