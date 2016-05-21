/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import MainInterfaces.DBAccess;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Julian
 */
public class Ticket {
    private String ticket_id, person_id, ttype_id, ciudad, categoria, evento, fecha, lugar;
    
    

    public Ticket(){}

    public Ticket(String ticket,String person, String ttype){
        ticket_id=ticket;
        person_id=person;
        ttype_id=ttype;
    }
   
    public Ticket(String id_user){
        person_id=id_user;
    }
       
    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setTtype_id(String ttype_id) {
        this.ttype_id = ttype_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

   
    //tipos de eventos que tienen boletas con este usuario
    public ResultSet buscarCategorias(DBAccess dba) throws SQLException{
        return dba.consultar("SELECT ec.ecategory " +
        "    from EVENT_CATEGORY ec inner join EVENT_TYPE et" +
        "    on ec.ecategory_id = et.ecategory_id" +
        "    inner join event ev on ev.etype_id = et.etype_id" +
        "    inner join ticket_type tt on ev.event_id = tt.event_id" +
        "    inner join ticket tc on tc.ttype_id = tt.ttype_id" +
        "    AND tc.person_id = "+person_id);
     
    }
    
    //se cambia la categoria por la seleccionada
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    //Segun la categoria de arriba me trae las ciudades
    public String buscarCiudades(){
       return return dba.consultar("select city_name from city " +
            "inner join place on city.city_id=place.city_id " +
            "inner join event on event.place_id = place.place_id " +
            "inner join event_type on event.ETYPE_ID = event_type.ETYPE_ID " +
            "INNER JOIN EVENT_CATEGORY ON event_type.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID " +
            "AND EVENT_CATEGORY.ECATEGORY = "+ categoria +
            " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
            "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
            "AND ticket.PERSON_ID = "+person_id);    
    }
    
    //se cambia por la ciudad seleccionada
     public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
     //buscamos los eventos en esa ciudad
    public String buscarEventos(){
        return("select ETYPE_NAME from event_type " +
            "inner join event on event.etype_id = event_type.etype_id " +
            "inner join place on event.place_id = place.place_id " +
            "inner join city on place.city_id = city.city_id " +
            "AND city.city_name = "+ ciudad + 
            "INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
            "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
            "AND ticket.PERSON_ID = "+ person_id);  
            
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
    
    
    //revisar este!!
    //mostramos la fecha y hora del evento seleccionado
    public String buscarFecha(){
        return ("select DATE_HOUR from event" +
        "inner join event_type on event.etype_id = event_type.etype_id " +
        "and event_type.etype_name = "+categoria+
        " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
        "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
        "AND ticket.PERSON_ID = "+person_id);
    }

    //se cambia la fecha por la encontrada en la consulta anterior
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    //mostrar el lugar del evento que se realiza en esa fecha
    public ResultSet buscarLugar(DBAccess dba) throws SQLException{
        return dba.consultar("inner join event on event.place_id = place.place_id " +
                    "and event.DATE_HOUR = "+fecha +
                    " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
                    "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
                    "AND ticket.PERSON_ID = "+person_id);
    }
    
    //lugar seleccionado
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    //PROBAR ESTE CODIGO
    
    //boletas compradas para el evento con dicha descripción anterior
    public String buscarBoletas(){
        return("SELECT DISTINCT tick_type,ttype_cost,count(TICKET_ID)" +
        "FROM ticket_type " +
        "INNER JOIN event ON TICKET_TYPE.EVENT_ID = event.EVENT_ID" +
        "INNER JOIN place ON event.place_id = place.place_id" +
        "AND place.place_name = "+ lugar +
        " INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID" +
        "AND ticket.PERSON_ID = "+ person_id +
        "GROUP BY tick_type ");
    
    }
        
    public String buscarEventId(){
        return ("SELECT event_id "+
                "from event e " +
                "inner join place p on p.place_id = p.place_id " +
                "inner join city c on c.city_id = c.city_id " +
                "inner join event_type et on et.etype_id = e.etype_id " +
                "AND c.city_name = "+ciudad  +
                "   AND et.etype_name = "+ evento +
                " AND e.date_hour = "+ fecha +
                " And p.place_name = "+ lugar);
      
    }
    
}
   
