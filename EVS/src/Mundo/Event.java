/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import java.sql.Timestamp;
import java.util.Calendar;
/**
 *
 * @author Julian
 */
public class Event {
    
    public static String consultarPorId(String id){
        return ("SELECT * FROM EVENT WHERE EVENT_ID = "+id);    
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
    
    public static String consultarTodasCiudades(){
        return "SELECT CITY_NAME FROM CITY";
    }
    
    public static String consultarEventCategoryNext(){
        return  "SELECT ECATEGORY FROM EVENT_CATEGORY"
                + "INNER JOIN EVENT_TYPE ON EVENT_CATEGORY.ECATEGORY_ID = EVENT_TYPE.ECATEGORY_ID"
                + "INNER JOIN EVENT ON EVENT_TYPE.ETYPE_ID = EVENT.ETYPE_ID"
                + consularEventosNext();
    }
    
    public static String preguntaEventCategory(String eventCategory){
        return "AND ECATEGORY = '" + eventCategory + "'";
    }
    
    public static String consultarCiudadNext(String eventCategory){
        return  "SELECT CITY_NAME FROM CITY"
                + "INNER JOIN PLACE ON CITY.CITY_ID = PLACE.CITY_ID"
                + "INNER JOIN EVENT ON PLACE.PLACE_ID = EVENT.PLACE_ID"
                + consularEventosNext()
                + "INNER JOIN EVENT_TYPE ON EVENT.ETYPE_ID = EVENT_TYPE.ETYPE_ID"
                + "INNER JOIN EVENT_CATEGORY ON EVENT_TYPE.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID"
                + preguntaEventCategory(eventCategory);
    }
    
    public static String preguntaCiudad(String city_Name){
        return "AND CITY_NAME = '" + city_Name + "'";
    }
    
    public static String consultarNombreEventoNext(String city_Name,String eventCategory){
        return "SELECT ETYPE_NAME FROM EVENT_TYPE"
                + "INNER JOIN EVENT_CATEGORY ON EVENT_TYPE.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID"
                + preguntaEventCategory(eventCategory)
                + "INNER JOIN EVENT ON EVENT_TYPE.ETYPE_ID = EVENT.ETYPE_ID"
                + consularEventosNext()
                + "INNER JOIN PLACE ON EVENT.PLACE_ID = PLACE.PLACE_ID"
                + "INNER JOIN CITY ON PLACE.CITY_ID = CITY.CITY_ID"
                + preguntaCiudad(city_Name);
    }
    
    public static String preguntaNombreEvento(String nombreEvento){
        return "AND ETYPE_NAME = '" + nombreEvento + "'";
    }
    
    
    
    public static String consultarDireccionLugarNext(String nombreEvento ,String city_Name,String eventCategory){
        return "SELECT PLACE_ADDRESS FROM PLACE"
                + "INNER JOIN CITY ON PLACE.CITY_ID = CITY.CITY_ID"
                + preguntaCiudad(city_Name)
                + "INNER JOIN EVENT ON PLACE.PLACE_ID = EVENT.PLACE_ID"
                + consularEventosNext()
                + "INNER JOIN EVENT_TYPE ON EVENT.ETYPE_ID = EVENT_TYPE.ETYPE_ID"
                + preguntaNombreEvento(nombreEvento)
                + "INNER JOIN EVENT_CATEGORY ON EVENT_TYPE.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID"
                + preguntaEventCategory(eventCategory);
    }
    
    public static String preguntaDireccionLugarNext(String direccionLugar){
        return "AND PLACE_ADDRESS = '" + direccionLugar + "'";
    }
    
    
    
    public static String consularEventosNext(){
        return "AND DATE_HOUR >= SYSDATE";
    }
    
}
