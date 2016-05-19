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
    
    public Connection getConexion() { return conexion; }
    public void setConexion(Connection conexion) { this.conexion = conexion; }
    
    public dbAccess Conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String DB = "jdbc:oracle:thin:@dbeafit.cyzd3byk9uno.us-east-1.rds.amazonaws.com:1521:DB20161";
            conexion= DriverManager.getConnection(DB,"jbusta16","mlyBQM93");
          
            if(conexion!=null){
                System.out.println("Conexion exitosa a esquema JBUSTA16");
            } else {
                System.out.println("Conexion fallida");
            }
            
            ResultSet st = conexion.createStatement().executeQuery("SELECT * FROM CITY C INNER JOIN PLACE P ON P.CITY_ID = C.CITY_ID");
            while (st.next()) {
                Array []data;
                data.add(st.getString(1), st.getString(2), st.getString(3), st.getString(4), st.getString(5), st.getString(6));
            }
        } catch(Exception e){ e.printStackTrace(); }
    return this;
    }
}