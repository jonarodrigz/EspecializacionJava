package edu.formas.FM3S6.modelo.dao;

import edu.formas.FM3S6.modelo.dominio.HibernateUtil;
import edu.formas.FM3S6.modelo.entidad.Cliente;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class daoCliente {

    public List<Cliente> getAll() {
        //System.out.println("Aca entro");
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Cliente").list();

    }
    public Cliente getCliById(int id){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Cliente cli = (Cliente)sesion.get(Cliente.class, id);
        return cli;
    }

    public boolean Insertar(Cliente cli) {
        boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            sesion.save(cli);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }

    public boolean Actualizar(Cliente cli) {
         boolean resultado = false;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = sesion.beginTransaction();
        try {
            Cliente cl = (Cliente) sesion.get(Cliente.class, cli.getIdCliente());
            cl.setNombre(cli.getNombre());
            cl.setApellido(cli.getApellido());
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
            Cliente cli = (Cliente) sesion.get(Cliente.class, id);
            sesion.delete(cli);
            ts.commit();
            sesion.close();
            resultado = true;
        } catch (Exception e) {
            ts.rollback();
        }

        return resultado;
    }
}
