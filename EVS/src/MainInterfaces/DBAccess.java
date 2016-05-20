package MainInterfaces;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DBAccess {
    
private Connection conexion;
    
    public DBAccess(){
        conectar();
    }

    public Connection getConexion() { return conexion; }
    public void setConexion(Connection conexion) { this.conexion = conexion; }
    public DBAccess conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String DB = "jdbc:oracle:thin:@dbeafit.cyzd3byk9uno.us-east-1.rds.amazonaws.com:1521:DB20161";
            conexion= DriverManager.getConnection(DB,"jbusta16","mlyBQM93");
          
            if(conexion!=null){
                System.out.println("Conexion exitosa a esquema JBUSTA16");
            } else {
                System.out.println("Conexion fallida");
            }
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
         try {
             conexion.rollback();
         } catch (SQLException ex) {
             Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
         }
        e.printStackTrace();
        return false;
    }
     return true;
    }
    
    public ResultSet consultar(String sql){
        ResultSet salida = null;
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
