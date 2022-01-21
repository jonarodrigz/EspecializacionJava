package edu.formas.s7.modelo.dominio;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class operacionesBD {
    private conexionBD conexion;
    public operacionesBD(){
        this.conexion = new conexionBD();
    }
    public List<Object[]> consultarBD(String sql){
        //Select
        List<Object[]> lista = new ArrayList();
        try{
            this.conexion.abrirConexion();
            Statement sentencia = this.conexion.getSentencia();
            ResultSet rs = sentencia.executeQuery(sql);
            int numColumnas = rs.getMetaData().getColumnCount();
            while (rs.next()){
                Object fila[] = new Object[numColumnas];
                for (int i=0;i<numColumnas;i++)
                    fila[i] = rs.getObject(i+1);
                lista.add(fila);
            }
            this.conexion.cerrarConexion();
        }
        catch (Exception e){
            System.out.println("Error en la consulta " + e.getMessage());
        }
        return lista;
    }
    public boolean ejecutarSQL(String sql){
        //Insert, Update, Delete
        boolean r=false;
        try{
            this.conexion.abrirConexion();
            Statement sentencia = this.conexion.getSentencia();
            r = !sentencia.execute(sql);
        }
        catch (Exception e){
            System.out.println("Error"+ e.getMessage());
        }
        return r;
    }
}
