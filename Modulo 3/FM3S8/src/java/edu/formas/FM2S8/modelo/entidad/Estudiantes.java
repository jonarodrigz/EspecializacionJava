package edu.formas.FM2S8.modelo.entidad;
// Generated 11-16-2021 06:36:58 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Estudiantes generated by hbm2java
 */
@Entity
@Table(name="estudiantes"
    ,catalog="evaluacionm3"
)
public class Estudiantes  implements java.io.Serializable {


     private Integer idestudiante;
     private String nombre;
     private String apellido;
     private String email;
     private String carrera;

    public Estudiantes() {
    }

    public Estudiantes(String nombre, String apellido, String email, String carrera) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.email = email;
       this.carrera = carrera;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idestudiante", unique=true, nullable=false)
    public Integer getIdestudiante() {
        return this.idestudiante;
    }
    
    public void setIdestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
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

    
    @Column(name="email", length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="carrera", length=100)
    public String getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }




}


