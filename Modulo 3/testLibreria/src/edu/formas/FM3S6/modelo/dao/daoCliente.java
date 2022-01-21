package edu.formas.FM3S6.modelo.dao;

import edu.formas.FM3S6.modelo.dominio.HibernateUtil;
import edu.formas.FM3S6.modelo.entidad.Cliente;
import java.util.List;
import org.hibernate.Session;


public class daoCliente {
    
        public List<Cliente> getAll()
    {   
      //  System.out.println("Aca entro");
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Cliente").list();
       
    }
}
