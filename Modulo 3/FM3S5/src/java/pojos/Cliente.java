package pojos;
// Generated 11-04-2021 07:06:21 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name="cliente"
    ,catalog="evaluacionm2"
)
public class Cliente  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String apellido;
     private String documento;
     private String tipoDoc;
     private String tipoCliente;
     private Set cuentas = new HashSet(0);

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String documento, String tipoDoc, String tipoCliente, Set cuentas) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.documento = documento;
       this.tipoDoc = tipoDoc;
       this.tipoCliente = tipoCliente;
       this.cuentas = cuentas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nombre", length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido", length=100)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="documento", length=20)
    public String getDocumento() {
        return this.documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    
    @Column(name="tipoDoc", length=4)
    public String getTipoDoc() {
        return this.tipoDoc;
    }
    
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    
    @Column(name="tipoCliente", length=3)
    public String getTipoCliente() {
        return this.tipoCliente;
    }
    
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set getCuentas() {
        return this.cuentas;
    }
    
    public void setCuentas(Set cuentas) {
        this.cuentas = cuentas;
    }




}


