package edu.formas.FM3S6.modelo.dao;

import edu.formas.FM3S6.modelo.dominio.HibernateUtil;
import edu.formas.FM3S6.modelo.entidad.Cliente;
import edu.formas.FM3S6.modelo.entidad.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class daoUsuario {
      public List<Usuario> getAll() {
       
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Usuario").list();

    }

    public boolean Insertar(Usuario usr) {
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            sesion.save(usr);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }

    public boolean Actualizar(Usuario usr) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Usuario us = (Usuario) sesion.get(Usuario.class, usr.getLogin());
           us.setLogin(usr.getLogin());
           us.setNombre(usr.getNombre());
           us.setApellido(usr.getApellido());
           us.setClave(usr.getClave());
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }

    public boolean Eliminar(String login) {
          boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Usuario us = (Usuario) sesion.get(Usuario.class, login);
            sesion.delete(us);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }
}
