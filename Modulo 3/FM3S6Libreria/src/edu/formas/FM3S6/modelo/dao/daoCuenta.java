package edu.formas.FM3S6.modelo.dao;

import edu.formas.FM3S6.modelo.dominio.HibernateUtil;
import edu.formas.FM3S6.modelo.entidad.Abonos;
import edu.formas.FM3S6.modelo.entidad.Cuenta;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class daoCuenta {
      public List<Cuenta> getAll() {
        //System.out.println("Aca entro");
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Cuenta").list();

    }

      public Cuenta getCtaById(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Cuenta cta = (Cuenta)sesion.get(Cuenta.class, id);
        return cta;
    }
    public boolean Insertar(Cuenta cta) {
        boolean resultado = false;
       
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            sesion.save(cta);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }

    public boolean Actualizar(Cuenta cta) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            
            Cuenta ct = (Cuenta) sesion.get(Cuenta.class, cta.getNumeroCuenta());
            ct.setCliente(cta.getCliente());
           // ct.setAbonoses(cta.getAbonos());
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }

    public boolean Eliminar(int id) {
          boolean resultado = false;
          daoAbonos daoA = new daoAbonos();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            if(daoA.EliminarByNCuenta(id)){
            Cuenta cta = (Cuenta) sesion.get(Cuenta.class, id);
            sesion.delete(cta);
            ts.commit();
            sesion.close();
            resultado = true; 
            }else{
                System.out.println("Error eliminado abonos");
            }
            
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }
    
    public float calcularSaldo(Cuenta cta){
        float saldo = 0f;
        daoAbonos daoAbono = new daoAbonos();
        List<Abonos> abonos = daoAbono.getAbonoByNCuenta(cta.getNumeroCuenta());
        
        for(Abonos a: abonos){
            saldo += a.getMontoAbono();
        }
        
        return saldo;
    }
}
