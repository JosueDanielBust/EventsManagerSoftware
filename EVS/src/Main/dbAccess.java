package Main;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;

public class dbAccess {
    //objeto de conexion 
    
    private Connection conexion;
    //para conectarse
    
    
  public static void main (String args []) throws SQLException
  {
    try 
    {
     Class.forName ("oracle.jdbc.driver.OracleDriver");
    } 
    catch (ClassNotFoundException e) 
    {
     e.printStackTrace();
    }

    Connection conn = DriverManager.getConnection
         ("jdbc:oracle:oci:@ORACLEBD", "user", "passw");
          //               @TNSNames_Entry,  userid,  password

    Statement stmt = conn.createStatement();
    ResultSet rset = 
              stmt.executeQuery("select BANNER from SYS.V_$VERSION");
    while (rset.next())
          System.out.println (rset.getString(1));   // Print col 1
    stmt.close();
  }
  
  
  //para escribir en Java  procedimientos almacenados, funciones,  triggers ... 
  public static String showBanner() throws SQLException
  {
    String banner="";
    Connection conn = 
    (new oracle.jdbc.driver.OracleDriver()).defaultConnection();

    Statement stmt = conn.createStatement();
    ResultSet rset = 
              stmt.executeQuery("select BANNER from SYS.V_$VERSION");
    while (rset.next())
           banner += rset.getString(1);          
    //stmt.close(); NO CERRAR LA CONEXION
    return banner;
  }
  
  
  
  
  
}
  