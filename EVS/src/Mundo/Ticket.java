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

   
    //tipos de eventos que tienen boletas con este usuario
    public static String buscarCategorias(String person_id){
        return ("SELECT ec.ecategory " +
        "    from EVENT_CATEGORY ec "+
        "    inner join EVENT_TYPE et on ec.ecategory_id = et.ecategory_id" +
        "    inner join event ev on ev.etype_id = et.etype_id" +
        "    inner join ticket_type tt on ev.event_id = tt.event_id" +
        "    inner join ticket tc on tc.ttype_id = tt.ttype_id" +
        "    AND tc.person_id = "+person_id);
     
    }
   
    //Segun la categoria de arriba me trae las ciudades
    public static String buscarCiudades(String categoria,String person_id){
       return ("select city_name "
                + "from city "
                + "inner join place on city.city_id = place.city_id " +
                "inner join event on event.place_id = place.place_id " +
                "inner join event_type on event.ETYPE_ID = event_type.ETYPE_ID " +
                "INNER JOIN EVENT_CATEGORY ON event_type.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID " +
                "AND EVENT_CATEGORY.ECATEGORY = "+ categoria +
                " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
                "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
                "AND ticket.PERSON_ID = "+person_id);    
    }
    
    
     //buscamos los eventos en esa ciudad
    public static String buscarEventos(String ciudad, String person_id,String categoria){
        return("select ETYPE_NAME from event_type " +
            "inner join event on event.etype_id = event_type.etype_id " +
            "inner join place on event.place_id = place.place_id " +
            "inner join city on place.city_id = city.city_id " +       
            " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
            "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
            "AND ticket.PERSON_ID = "+ person_id +
            " AND city.city_name = "+ ciudad + 
            " AND EVENT_CATEGORY.ECATEGORY = "+ categoria);  
            
    }

    
    //revisar este!!
    //mostramos la fecha y hora del evento seleccionado
    public static String buscarFecha(String categoria,String person_id,String ciudad,String evento){
        return ("select DATE_HOUR from event" +
        "inner join event_type on event.etype_id = event_type.etype_id " +
        " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
        "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
        "AND ticket.PERSON_ID = "+person_id +
        " AND city.city_name = "+ ciudad + 
        " and event_type.etype_name =  "+ evento + 
        " AND EVENT_CATEGORY.ECATEGORY = "+ categoria);
    }

    //mostrar el lugar del evento que se realiza en esa fecha
    public static String buscarLugar(String fecha,String categoria,String person_id,String ciudad,String evento){
        return ("inner join event on event.place_id = place.place_id " +
                "and event.DATE_HOUR = "+fecha +
                " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
                "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
                " AND ticket.PERSON_ID = "+person_id+
               " AND city.city_name = "+ ciudad + 
                " and event_type.etype_name =  "+ evento + 
                " AND EVENT_CATEGORY.ECATEGORY = "+ categoria);
    }

    //PROBAR ESTE CODIGO
    
    //boletas compradas para el evento con dicha descripción anterior
    public static String buscarBoletas(String lugar,String fecha,String categoria,String person_id,String ciudad,String evento){
        return("SELECT DISTINCT tick_type,ttype_cost,count(TICKET_ID)" +
        " FROM ticket_type " +
        " INNER JOIN event ON TICKET_TYPE.EVENT_ID = event.EVENT_ID" +
        " INNER JOIN place ON event.place_id = place.place_id" +
        " AND place.place_name = "+ lugar +
        " INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID" +
        " AND ticket.PERSON_ID = "+ person_id +
        " AND ticket.PERSON_ID = "+person_id+
        " AND city.city_name = "+ ciudad + 
        " and event_type.etype_name =  "+ evento + 
        " AND EVENT_CATEGORY.ECATEGORY = "+ categoria +               
        " GROUP BY tick_type ");
    
    }
        
    public static String buscarEventId(String ciudad,String evento,String fecha,String lugar){
        return ("SELECT event_id "+
                "from event e " +
                "inner join place p on p.place_id = p.place_id " +
                "inner join city c on c.city_id = c.city_id " +
                "inner join event_type et on et.etype_id = e.etype_id " +
                "AND c.city_name = " + ciudad +
                " AND et.etype_name = "+ evento +
                " AND e.date_hour = "+ fecha +
                " And p.place_name = "+ lugar);
      
    }
    
    public static String consultaUnica(String select){
        return ("select * "
                + "from event " +
                "INNER JOIN event_type on event.etype_id = event_type.etype_id" +
                "INNER JOIN event_category on event_type.ecategory_id = event_category.ecategory_id" +
                "INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID" +
                "INNER JOIN place on event.place_id = place.place_id" +
                "INNER JOIN city on city.city_id = place.city_id" +
                "INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID" +
                "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID" 
                 );
    }
    
}
   
