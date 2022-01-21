package edu.formas.FM2S8.modelo.dao;

import edu.formas.FM2S8.modelo.dominio.HibernateUtil;
import edu.formas.FM2S8.modelo.entidad.Usuario;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;


public class daoUsuario {
    public List<Usuario> consultarTodos(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        return sesion.createQuery("from Usuario").list();

    }
    
    public Usuario login(String us, String cl){
        Usuario usuario = new Usuario();
        List<Usuario> lst = this.consultarTodos();
        boolean encontrado = false;
        int cont = 0;
        String key = this.toMD5(cl);
        while(cont < lst.size() && !encontrado){
            if(lst.get(cont).getLogin().equals(us)){
                if(lst.get(cont).getClave().equals(key)){
                    encontrado = true;
                    usuario = lst.get(cont);
                }
                else{
                    break;
                }
            }
            else{
                cont++;
            }
        }
        return usuario;
    }

    private String toMD5(String input) {
        MessageDigest md = null;
        byte[] raw = null;
        try{
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(input.getBytes("UTF-8"));
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return String.format("%032x", new BigInteger(1, md.digest()));
    }
}
