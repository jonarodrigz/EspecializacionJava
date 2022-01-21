package edu.formas.modelo.dao;

import edu.formas.modelo.dominio.HibernateUtil;
import edu.formas.modelo.entidad.Cliente;
import java.util.List;
import org.hibernate.Session;


public class daoCliente {
    public List<Cliente> getAll(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Cliente").list();
    }
}
