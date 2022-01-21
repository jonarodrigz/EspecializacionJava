package edu.formas.s7.modelo.dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conexionBD {
    private Connection cn;
    private String usuario;
    private String clave;
    private String url;
    private Statement sentencia;
    
    public conexionBD(){
        this.usuario = "root";
        this.clave = "root1234";
        this.url = "jdbc:mysql://localhost:3306/evaluacionm2";
        this.cn = null;
        this.sentencia = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println("Error " + e.getMessage());
        }    
    }
    public void abrirConexion(){
        try{
            this.cn = DriverManager.getConnection(this.url,this.usuario,this.clave);            
        }
        catch (SQLException e){
            System.out.println("Error de conexion " + e.getMessage());
        }
    }
    public Statement getSentencia(){
        try{
            this.sentencia = this.cn.createStatement();
        }
        catch (SQLException e){
            System.out.println("Error en la sentencia " + e.getMessage());
        }
        return this.sentencia;
    }
    public void cerrarConexion(){
        try{
            this.cn.close();
        }
        catch (Exception e){
            System.out.println("Error al cerrar la conexion");
        }
    }
}
