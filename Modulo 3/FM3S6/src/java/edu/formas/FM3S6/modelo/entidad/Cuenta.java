package edu.formas.FM3S6.modelo.entidad;
// Generated 11-15-2021 08:34:42 PM by Hibernate Tools 4.3.1


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cuenta generated by hbm2java
 */
@Entity
@Table(name="cuenta"
    ,catalog="modulo3"
)
public class Cuenta  implements java.io.Serializable {


     private Integer numeroCuenta;
     private Cliente cliente;
     private Float saldo;
     private List<Abonos> lstabonos = new ArrayList<Abonos>();

    public Cuenta() {
    }

	
    public Cuenta(Cliente cliente) {
        this.cliente = cliente;
    }
    public Cuenta(Cliente cliente, Float saldo) {
       this.cliente = cliente;
       this.saldo = saldo;
       
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="numeroCuenta", unique=true, nullable=false)
    public Integer getNumeroCuenta() {
        return this.numeroCuenta;
    }
    
    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCliente", nullable=false)
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    @Column(name="saldo", precision=10)
    public Float getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cuenta")
    public List<Abonos> getAbonoses() {
        return this.lstabonos;
    }
    
    public void setAbonoses(List<Abonos> abonos) {
        this.lstabonos = abonos;
    }




}


