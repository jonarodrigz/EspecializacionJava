    package edu.formas.FM2S8.modelo.dao;

import edu.formas.FM2S8.modelo.dominio.HibernateUtil;
import edu.formas.FM2S8.modelo.entidad.Estudiantes;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class daoEstudiante {
     public List<Estudiantes> getAll() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Estudiantes").list();

    }
    public Estudiantes getEstById(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Estudiantes est = (Estudiantes)sesion.get(Estudiantes.class, id);
        return est;
    }

    public boolean Insertar(Estudiantes est) {
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            sesion.save(est);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }

    public boolean Actualizar(Estudiantes est) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Estudiantes es = (Estudiantes) sesion.get(Estudiantes.class, est.getIdestudiante());
            es.setNombre(est.getNombre());
            es.setApellido(est.getApellido());
            es.setEmail(est.getEmail());
            es.setCarrera(est.getCarrera());
            
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
            Estudiantes est = (Estudiantes) sesion.get(Estudiantes.class, id);
            sesion.delete(est);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }
}
