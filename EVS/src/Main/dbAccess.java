package Main;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;

public class dbAccess {
    //objeto de conexion 
    
private Connection conexion;

    public static void main(String[] args) {
        dbAccess access = new dbAccess();
        access.conectar();
        ResultSet resultados = access.consultar("SELECT CITY_NAME FROM CITY");        
        if (resultados != null) {
            try {
                System.out.println("CIUDAD");
                System.out.println("------------");
                while (resultados.next()) {
                    System.out.println(resultados.getString(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public Connection getConexion() { return conexion; }
    public void setConexion(Connection conexion) { this.conexion = conexion; }
    
    public dbAccess conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String DB = "jdbc:oracle:thin:@dbeafit.cyzd3byk9uno.us-east-1.rds.amazonaws.com:1521:DB20161";
            conexion= DriverManager.getConnection(DB,"jbusta16","mlyBQM93");
          
            if(conexion!=null){
                System.out.println("Conexion exitosa a esquema JBUSTA16");
            } else {
                System.out.println("Conexion fallida");
            }
            /*
            ResultSet st = conexion.createStatement().executeQuery("SELECT * FROM CITY C INNER JOIN PLACE P ON P.CITY_ID = C.CITY_ID");
            while (st.next()) {
                Array []data;
                data.add(st.getString(1), st.getString(2), st.getString(3), st.getString(4), st.getString(5), st.getString(6));
            }
            */
        } catch(Exception e){ e.printStackTrace(); }
    return this;
    }
    
    public boolean ejecutar(String sql){
     try{
         Statement st = getConexion().createStatement(
         ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
         st.executeUpdate(sql);
         getConexion().commit();
     }catch(SQLException e){
        e.printStackTrace();
        return false;
    }
     return true;
    }
    
    public ResultSet consultar(String sql){
        ResultSet salida=null;
        try{
            Statement st = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            salida = st.executeQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
             return null;
        }
        
        return salida;
    }
 
}
