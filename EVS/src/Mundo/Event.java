/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import MainInterfaces.DBAccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian
 */

public class Event {
    private static String event_id,ecategoria,eName,ciudad,direccion,fecha;

    public static void consultarId(){
        String sqlc= Event.buscarIdEvent();
        String ide="";
            
        try{
            ResultSet rs= DBAccess.consultar(sqlc);
            if(rs.next())
               ide=rs.getString(1);
            System.out.println("El evento consultado tiene id: "+ide);
            Event.setEvent_id(ide);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Mensaje de Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static String consultarPorId(){
        return ("SELECT *  FROM EVENT WHERE EVENT_ID = "+getEvent_id());    
    }
    
    public static String consultarEventCategory(String id_ec){
        return ("Select ECATEGORY FROM EVENT_CATEGORY WHERE ECATEGORY_ID = "+id_ec);
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
                + " INNER JOIN EVENT_TYPE ON EVENT_CATEGORY.ECATEGORY_ID = EVENT_TYPE.ECATEGORY_ID"
                + " INNER JOIN EVENT ON EVENT_TYPE.ETYPE_ID = EVENT.ETYPE_ID "
                + consultarEventosNext();
    }
    
    public static String preguntaEventCategory(){
        return " AND ECATEGORY = '" + ecategoria + "' ";
    }
    
    public static String consultarCiudadNext(){
        return  "SELECT CITY_NAME FROM CITY "
                + "INNER JOIN PLACE ON CITY.CITY_ID = PLACE.CITY_ID "
                + "INNER JOIN EVENT ON PLACE.PLACE_ID = EVENT.PLACE_ID "
                + consultarEventosNext()
                + " INNER JOIN EVENT_TYPE ON EVENT.ETYPE_ID = EVENT_TYPE.ETYPE_ID "
                + " INNER JOIN EVENT_CATEGORY ON EVENT_TYPE.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID "
                + preguntaEventCategory();
    }
    
    public static String preguntaCiudad(){
        return " AND CITY_NAME = '" + ciudad + "' ";
    }
    
    public static String consultarNombreEventoNext(){
        return "SELECT ETYPE_NAME FROM EVENT_TYPE "
                + "INNER JOIN EVENT_CATEGORY ON EVENT_TYPE.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID "
                + preguntaEventCategory()
                + " INNER JOIN EVENT ON EVENT_TYPE.ETYPE_ID = EVENT.ETYPE_ID "
                + consultarEventosNext()
                + " INNER JOIN PLACE ON EVENT.PLACE_ID = PLACE.PLACE_ID "
                + " INNER JOIN CITY ON PLACE.CITY_ID = CITY.CITY_ID"
                + preguntaCiudad();
    }
    
    public static String consultarFechas(){
        return  ("SELECT TO_CHAR(DATE_HOUR) " +
                "FROM EVENT " +
                "INNER JOIN EVENT_TYPE ON EVENT.ETYPE_ID = EVENT_TYPE.ETYPE_ID " +
                "INNER JOIN EVENT_CATEGORY ON EVENT_TYPE.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID " +
                "INNER JOIN PLACE ON EVENT.PLACE_ID = PLACE.PLACE_ID " +
                "INNER JOIN CITY ON PLACE.CITY_ID = CITY.CITY_ID " +
                "AND EVENT_CATEGORY.ECATEGORY = '"+ ecategoria+"'"+
                " AND CITY.CITY_NAME = '"+ciudad+"'" +
                " AND EVENT_TYPE.ETYPE_NAME = '"+eName+"'"+
                " AND PLACE.PLACE_ADDRESS = '"+direccion+"'");
    }
    
     public static String consultarFechasEventoNext(){
        return  ("SELECT TO_CHAR(DATE_HOUR) " +
                "FROM EVENT " +
                "INNER JOIN EVENT_TYPE ON EVENT.ETYPE_ID = EVENT_TYPE.ETYPE_ID " +
                "INNER JOIN EVENT_CATEGORY ON EVENT_TYPE.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID " +
                "INNER JOIN PLACE ON EVENT.PLACE_ID = PLACE.PLACE_ID " +
                "INNER JOIN CITY ON PLACE.CITY_ID = CITY.CITY_ID " +
                "AND EVENT_CATEGORY.ECATEGORY = '"+ ecategoria+"'"+
                " AND CITY.CITY_NAME = '"+ciudad+"'" +
                " AND EVENT_TYPE.ETYPE_NAME = '"+eName+"'"+
                " AND PLACE.PLACE_ADDRESS = '"+direccion+"' "
                + consultarEventosNext());
    }
    
    
    public static String preguntaNombreEvento(){
        return " AND ETYPE_NAME = '" + eName + "' ";
    }
    
    
    
    public static String consultarDireccionLugarNext(){
        return "SELECT PLACE_ADDRESS FROM PLACE "
                + "INNER JOIN CITY ON PLACE.CITY_ID = CITY.CITY_ID "
                + preguntaCiudad()
                + " INNER JOIN EVENT ON PLACE.PLACE_ID = EVENT.PLACE_ID "
                + consultarEventosNext()
                + " INNER JOIN EVENT_TYPE ON EVENT.ETYPE_ID = EVENT_TYPE.ETYPE_ID "
                + preguntaNombreEvento()
                + " INNER JOIN EVENT_CATEGORY ON EVENT_TYPE.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID "
                + preguntaEventCategory();
    }
    
    public static String preguntaDireccionLugarNext(){
        return " AND PLACE_ADDRESS = '" + direccion + "' ";
    }
    
    public static String consultarEventosNext(){
        return " AND DATE_HOUR >= LOCALTIMESTAMP ";
    }
    
    
    
     public static String buscarIdEvent(){
        return ("SELECT EVENT_ID FROM V_EVENT "+
                " WHERE CITY_NAME = '"+Event.getCiudad()+"' "+
                " AND TO_CHAR(DATE_HOUR) = '"+Event.getFecha()+"' "+
                " AND PLACE_ADDRESS = '"+Event.getDireccion()+"'"+
                " AND ETYPE_NAME = '"+Event.getEname()+"'");
      
    }
    
      public static String buscarTicketTypes(){
          return("SELECT tt.tick_type "
                 + "FROM TICKET_TYPE tt"
                 +" INNER JOIN EVENT e ON tt.event_id = e.event_id "+
                  " AND e.event_id = '"+getEvent_id()+"' ");
      }
    
    
    public static void limpiarEvento(){
        setEvent_id("");
    }
      
    public static String getCiudad() {
        return ciudad;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static String getFecha() {
        return fecha;
    }

    public static void setCiudad(String ciudad) {
        Event.ciudad = ciudad;
    }

    public static void setDireccion(String direccion) {
        Event.direccion = direccion;
    }

    public static void setFecha(String fecha) {
        Event.fecha = fecha;
    }
 
    
    public static String getEname() {
        return eName;
    }

    public static void setEname(String ename) {
        Event.eName = ename;
    }  
    
    public static String getEvent_id() {
        return event_id;
    }

    public static String getCategoria() {
        return ecategoria;
    }

    public static void setEvent_id(String event_id) {
        Event.event_id = event_id;
    }

    public static void setCategoria(String categoria) {
        Event.ecategoria = categoria;
    }
    
    
}
