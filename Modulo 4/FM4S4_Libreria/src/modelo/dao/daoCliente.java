package modelo.dao;

import java.util.List;
import modelo.dominio.HibernateUtil;
import modelo.entidad.Clientes;
import org.hibernate.Session;


public class daoCliente {
    public List<Clientes> consultar() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Clientes").list();

    }
}
