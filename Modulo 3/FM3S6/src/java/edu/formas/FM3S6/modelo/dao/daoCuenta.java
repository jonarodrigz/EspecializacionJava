package edu.formas.FM3S6.modelo.dao;

import edu.formas.FM3S6.modelo.dominio.HibernateUtil;
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
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Cuenta cta = (Cuenta) sesion.get(Cuenta.class, id);
            sesion.delete(cta);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }
}
