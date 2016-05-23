
package Mundo;

import static Mundo.Event.getEvent_id;

/**
 *
 * @author Julian
 */
public class Ticket {
    public Ticket(){}
    
    
   public static String preguntaPersona(){
       return " AND ticket.PERSON_ID = "+Person.getPERSON_ID();
   }
   
   public static String preguntaCategoria(){
       return (" AND EVENT_CATEGORY.ECATEGORY = "+ Event.getCategoria());
   }
    public static String preguntaEname(){
        return (" AND event_type.etype_name =  "+ Event.getEname());
    }
    
    public static String preguntaCiudad(){
        return (" AND city.city_name = "+ Event.getCiudad());
    }
    
    public static String preguntaFecha(){
        return (" AND TO_CHAR(event.DATE_HOUR) = "+ Event.getFecha());
    }
   
    //tipos de eventos que tienen boletas con este usuario
    public static String buscarCategorias(){
        return ("SELECT ec.ecategory " +
        "    from EVENT_CATEGORY ec "+
        "    inner join EVENT_TYPE et on ec.ecategory_id = et.ecategory_id" +
        "    inner join event ev on ev.etype_id = et.etype_id" +
        "    inner join ticket_type tt on ev.event_id = tt.event_id" +
        "    inner join ticket on ticket.ttype_id = tt.ttype_id " +
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
                " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
                " INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
               preguntaCategoria()+ 
               preguntaPersona());   
    }
    
    
     //buscamos los eventos en esa ciudad
    public static String buscarEventos(){
        return("select ETYPE_NAME from event_type " +
            "inner join event on event.etype_id = event_type.etype_id " +
            "inner join place on event.place_id = place.place_id " +
            "inner join city on place.city_id = city.city_id " +       
            " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
            "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
            "INNER JOIN EVENT_CATEGORY ON event_type.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID " +
            preguntaPersona() +
            preguntaCiudad()+
            preguntaCategoria());  
            
    }

    
    //revisar este!!
    //mostramos la fecha y hora del evento seleccionado
    public static String buscarFecha(){
        return ("select TO_CHAR(DATE_HOUR) from event " +
                 "inner join place on event.place_id = place.place_id " +
                " inner join city on place.city_id = city.city_id " + 
                " inner join event_type on event.etype_id = event_type.etype_id " +
                " INNER JOIN EVENT_CATEGORY ON event_type.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID " +
                " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
                " INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +     
                preguntaPersona() +
                preguntaCiudad() +
                preguntaEname() +
                preguntaCategoria());
        
    }

    //mostrar el lugar del evento que se realiza en esa fecha
    public static String buscarDireccion(){
        return ("SELECT PLACE_ADDRESS FROM PLACE "+
                " inner join city on place.city_id = city.city_id " + 
                " inner join event on event.place_id = place.place_id " +
                " inner join event_type on event.etype_id = event_type.etype_id " +
                " INNER JOIN EVENT_CATEGORY ON event_type.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID " +
                " INNER JOIN TICKET_TYPE ON TICKET_TYPE.EVENT_ID = event.EVENT_ID " +
                "INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID " +
                preguntaPersona() +
                preguntaCiudad()+
                preguntaEname()+
                preguntaFecha()+
                preguntaCategoria());
                
    }

    //PROBAR ESTE CODIGO
    
    //boletas compradas para el evento con dicha descripciÃ³n anterior
    public static String buscarBoletas(){
        return("SELECT tick_type,ttype_cost" +
        " FROM ticket_type " +
        " INNER JOIN event ON TICKET_TYPE.EVENT_ID = event.EVENT_ID" +
        " inner join event_type on event.etype_id = event_type.etype_id " +
        " INNER JOIN EVENT_CATEGORY ON event_type.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID " +
        " INNER JOIN place ON event.place_id = place.place_id" +
        " AND place.place_address = "+ Event.getDireccion() +
        " inner join city on place.city_id = city.city_id " +        
        " INNER JOIN TICKET ON TICKET.TTYPE_ID = TICKET_TYPE.TTYPE_ID" +
        preguntaPersona() +
        preguntaCiudad() +
        preguntaEname() +  
        preguntaFecha()+
        preguntaCategoria());
    
    }
   
    public static String consultarPrecio(String tipo){
        return "Select tt.ttype_cost from "
                 +" TICKET_TYPE tt"
                 +" INNER JOIN EVENT e ON tt.event_id = e.event_id "
                 +" WHERE tt.event_id = '"+Event.getEvent_id()+"' "
                + " AND tt.tick_type = '"+tipo+"' ";
    }
}
