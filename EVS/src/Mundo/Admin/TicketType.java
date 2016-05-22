package Mundo.Admin;

public class TicketType {
    String TTYPE_ID, TICK_TYPE, TTYPE_COST, EVENT_ID, ONSALE_TICKETS;
    
    public TicketType(){}
    
    public String getTicketTypes(){
        String sql = "SELECT TICK_TYPE FROM TICKET_TYPE";
        return sql;
    }
    
    public String getID(String TICK_TYPE){
        String sql = "SELECT TTYPE_ID FROM TICKET_TYPE WHERE TICK_TYPE = " + TICK_TYPE;
        return sql;
    }
    
    public String create(String TICK_TYPE, String TTYPE_COST, String EVENT_ID, String ONSALE_TICKETS){
        String sql = "";
        return sql;
    }
}