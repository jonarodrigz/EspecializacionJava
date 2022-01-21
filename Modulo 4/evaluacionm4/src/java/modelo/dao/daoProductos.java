package modelo.dao;

import java.util.List;
import modelo.dominio.HibernateUtil;
import modelo.entidad.Productos;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class daoProductos {
    public List<Productos> getAll() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Productos").list();

    }
    public Productos getProById(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Productos est = (Productos)sesion.get(Productos.class, id);
        return est;
    }

    public boolean Insertar(Productos pr) {
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            sesion.save(pr);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }

    public boolean Actualizar(Productos prd) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Productos p = (Productos) sesion.get(Productos.class, prd.getIdproductos());
            p.setNombre(prd.getNombre());
            p.setPrecio(prd.getPrecio());
                      
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
            Productos p = (Productos) sesion.get(Productos.class, id);
            sesion.delete(p);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }
}
