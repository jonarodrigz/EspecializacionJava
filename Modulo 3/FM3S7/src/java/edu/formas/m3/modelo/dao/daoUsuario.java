package edu.formas.m3.modelo.dao;

import edu.formas.m3.modelo.dominio.HibernateUtil;
import edu.formas.m3.modelo.entidad.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class daoUsuario {
    public List<Usuario> consultarTodos(){
        List<Usuario> lst = new ArrayList<>();
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            lst = sesion.createQuery("from Usuario").list();
        }
        catch(HibernateException e){
            System.out.println("Error");
        }
        return lst;
    }
    
    public Usuario login(String us, String cl){
        Usuario usuario = new Usuario();
        List<Usuario> lst = this.consultarTodos();
        
        boolean encontrado = false;
        int cont = 0;
        String key = this.toMD5(cl);
        
        while (cont < lst.size() && !encontrado) {            
            if(lst.get(cont).getLogin().equals(us)){
                if(lst.get(cont).getClave().equals(key)){
                    encontrado = true;
                    usuario = lst.get(cont);
                            
                }
            }
        }
        return usuario;
    }

    private String toMD5(String cl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
