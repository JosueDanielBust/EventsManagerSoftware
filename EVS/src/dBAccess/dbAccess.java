/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dBAccess;

/**
 *
 * @author Julian
 */
public class dbAccess {
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
 }