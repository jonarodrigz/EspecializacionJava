package edu.formas.FM3S6.modelo.dao;

import edu.formas.FM3S6.modelo.dominio.HibernateUtil;
import edu.formas.FM3S6.modelo.entidad.Abonos;
import edu.formas.FM3S6.modelo.entidad.Cuenta;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class daoAbonos {
      public List<Abonos> getAll() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Abonos").list();

    }
      public List<Abonos> getAbonoByNCuenta(Integer nCuenta){
           Session sesion = HibernateUtil.getSessionFactory().openSession();
         return sesion.createQuery("from Abonos a Where a.cuenta.numeroCuenta="+nCuenta).list();
      }

    public boolean Insertar(Abonos abo) {
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            sesion.save(abo);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }

    public boolean Actualizar(Abonos abo) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Abonos ab = (Abonos) sesion.get(Abonos.class, abo.getIdAbono());
            ab.setCuenta(abo.getCuenta());
            ab.setFechaAbono(abo.getFechaAbono());
            ab.setMontoAbono(abo.getMontoAbono());
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
            Abonos abo = (Abonos) sesion.get(Abonos.class, id);
            sesion.delete(abo);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }
}
