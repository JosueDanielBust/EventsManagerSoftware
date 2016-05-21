/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import java.sql.ResultSet;
import MainInterfaces.DBAccess;
import java.sql.SQLException;
/**
 *
 * @author Julian
 */
public class Event {
private String id,type,place;
    
    public static String consultarPorId(String id){
        return ("SELECT *  FROM EVENT WHERE EVENT_ID = "+id);    
    }
    
    public static String consultarEventCategory(String id_c){
        return ("Select ECATEGORY FROM EVENT_CATEGORY WHERE ECATEGORY_ID = "+id_c);
    }
    
    public static String consultarETName(String id_et){
        return ("Select ETYPE_NAME FROM EVENT_TYPE WHERE ETYPE_ID = "+id_et);
    }
    
    public static String consultarLugar(String id_pl){
        return ("Select PLACE_NAME FROM PLACE WHERE PLACE_ID = "+id_pl);
    }
    
    public static String consultarCiudad(String id_ci){
        return ("Select CITY_NAME FROM PLACE p INNER JOIN CITY c ON p.CITY_ID = c.CITY_ID AND p.PLACE_ID = "+id_ci);
    }
     
    public static String consultarDir(String id_dir){
        return ("Select PLACE_ADDRESS FROM PLACE WHERE PLACE_ID = "+id_dir);
    }
    
    public static String consultarPType(String id_pt){
        return ("Select PLACE_TYPE FROM PLACE pl INNER JOIN PLACE_TYPE pt ON pl.PTYPE_ID = pt.PTYPE_ID WHERE PLACE_ID = "+id_pt);
    }
    
    public static String consultarRestricciones(String id_pl){
        return ("Select ACCESS_RESTRICTIONS FROM PLACE WHERE PLACE_ID = "+id_pl);
    }
    
    public static ResultSet consultarTodasCiudades(DBAccess dba) throws SQLException{
        return dba.consultar("SELECT CITY_NAME FROM CITY");
    }
    
}
