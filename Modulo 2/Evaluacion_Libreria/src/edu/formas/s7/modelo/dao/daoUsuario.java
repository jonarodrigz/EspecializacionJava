package edu.formas.s7.modelo.dao;

import edu.formas.s7.modelo.dominio.operacionesBD;
import edu.formas.s7.modelo.entidad.Usuario;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class daoUsuario {
    private operacionesBD op;
    public daoUsuario(){
        this.op = new operacionesBD();
    }
    public List<Usuario> getAll(){
        List<Usuario> ls = new ArrayList();
        String sql = "SELECT login, nombre, apellido, clave FROM Usuario";
        List<Object[]> lst = this.op.consultarBD(sql);
        for (int i=0;i<lst.size();i++){
            Object fila[] = lst.get(i);
            Usuario usr = new Usuario((String) fila[0], (String) fila[1], (String) fila[2], (String) fila[3]);
            ls.add(usr);
        }
        return ls;
    }
    public Usuario login(String log, String clave){
        Usuario usuario = new Usuario();
        List<Usuario> lst = this.getAll();
        boolean encontrado = false;
        int cont=0;
        String key = this.toMD5(clave);
        while (cont < lst.size() && !encontrado){
            if (lst.get(cont).getLogin().equals(log)){
                if (lst.get(cont).getClave().equals(key)){
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
    private String toMD5(String input){
        MessageDigest md = null;
        byte[] raw = null;
        try{
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(input.getBytes("UTF-8"));
        }
        catch (UnsupportedEncodingException | NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return String.format("%032x", new BigInteger(1, md.digest()));
    }
}
