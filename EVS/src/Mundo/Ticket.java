/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

/**
 *
 * @author Julian
 */
public class Ticket {
    public Ticket(){}

   public static String preguntaPersona(){
       return " AND ticket.PERSON_ID = = "+Person.getPERSON_ID();
   }
   
   public static String preguntaCategoria(){
       return (" AND EVENT_CATEGORY.ECATEGORY = "+ Event.getCategoria());
   }
    public static String preguntaEname(){
        return (" AND event_type.etype_name =  "+ Event.getEname());
    }
   
    //tipos de eventos que tienen boletas con este usuario
    public static String buscarCategorias(){
        return ("SELECT ec.ecategory " +
        "    from EVENT_CATEGORY ec "+
        "    inner join EVENT_TYPE et on ec.ecategory_id = et.ecategory_id" +
        "    inner join event ev on ev.etype_id = et.etype_id" +
        "    inner join ticket_type tt on ev.event_id = tt.event_id" +
        "    inner join ticket tc on tc.ttype_id = tt.ttype_id" +
        preguntaPersona());
     
    }
   
    //Segun la categoria de arriba me trae las ciudades
    public static String buscarCiudades(){
       return ("select city_name "
                + "from city "
                + "inner join place on city.city_id = place.city_id " +
                "inner join event on event.place_id = place.place_id " +
                "inner join event_type on event.ETYPE_ID = event_type.ETYPE_ID " +
                "INNER JOIN EVENT_CATEGORY ON event_type.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID " +
                preguntaCategoria()+
                " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
                "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
                preguntaPersona());   
    }
    
    
     //buscamos los eventos en esa ciudad
    public static String buscarEventos(String ciudad){
        return("select ETYPE_NAME from event_type " +
            "inner join event on event.etype_id = event_type.etype_id " +
            "inner join place on event.place_id = place.place_id " +
            "inner join city on place.city_id = city.city_id " +       
            " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
            "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
            preguntaPersona() +
            " AND city.city_name = "+ ciudad + 
            preguntaCategoria());  
            
    }

    
    //revisar este!!
    //mostramos la fecha y hora del evento seleccionado
    public static String buscarFecha(String ciudad){
        return ("select DATE_HOUR from event" +
        "inner join event_type on event.etype_id = event_type.etype_id " +
        " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
        "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
        preguntaPersona() +
        " AND city.city_name = "+ ciudad + 
        preguntaEname() +
        preguntaCategoria());
        
    }

    //mostrar el lugar del evento que se realiza en esa fecha
    public static String buscarLugar(String fecha,String ciudad){
        return ("inner join event on event.place_id = place.place_id " +
                "and event.DATE_HOUR = "+fecha +
                " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
                "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
                preguntaPersona() +
               " AND city.city_name = "+ ciudad + 
                preguntaEname()+
                preguntaCategoria());
    }

    //PROBAR ESTE CODIGO
    
    //boletas compradas para el evento con dicha descripción anterior
    public static String buscarBoletas(String lugar,String fecha,String ciudad){
        return("SELECT DISTINCT tick_type,ttype_cost,count(TICKET_ID)" +
        " FROM ticket_type " +
        " INNER JOIN event ON TICKET_TYPE.EVENT_ID = event.EVENT_ID" +
        " INNER JOIN place ON event.place_id = place.place_id" +
        " AND place.place_name = "+ lugar +
        " INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID" +
        preguntaPersona() +
        " AND city.city_name = "+ ciudad + 
        preguntaEname() +  
        preguntaCategoria() +               
        " GROUP BY tick_type ");
    
    }
        
    public static String buscarEventId(String ciudad,String fecha,String lugar){
        return ("SELECT event_id "+
                "from event e " +
                "inner join place p on p.place_id = p.place_id " +
                "inner join city c on c.city_id = c.city_id " +
                "inner join event_type et on et.etype_id = e.etype_id " +
                "AND c.city_name = " + ciudad +
                preguntaEname()+
                " AND e.date_hour = "+ fecha +
                " And p.place_name = "+ lugar);
      
    }
    
    
}
   
