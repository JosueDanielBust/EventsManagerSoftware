package Main;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;

public class dbAccess {
    //objeto de conexion 
    
private Connection conexion;

 public static void main(String[] args) {
  dbAccess obconeccion=new dbAccess();
    obconeccion.Conectar();
    }
    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public dbAccess Conectar()
    {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        String BaseDeDatos = "jdbc:oracle:thin:@dbeafit.cyzd3byk9uno.us-east-1.rds.amazonaws.com:1521:DB20161";
        conexion= DriverManager.getConnection(BaseDeDatos,"jbusta16","mlyBQM93");
        if(conexion!=null)
        {
        System.out.println("Conexion exitosa a esquema BDDEMO1");
        }
        else{System.out.println("Conexion fallida");}
        }
        catch(Exception e)
        {e.printStackTrace();}
       
    return this;
    }

}
