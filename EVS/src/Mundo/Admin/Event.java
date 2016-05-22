package Mundo.Admin;

public class Event {
    String EVENT_ID, ETYPE_ID, PLACE_ID, SOLD_TICK, DATE_HOUR;
    
    public Event(){}
    public Event(String ETYPE_ID, String PLACE_ID, String SOLD_TICK, String DATE_HOUR){
        this.ETYPE_ID = ETYPE_ID;
        this.PLACE_ID = PLACE_ID;
        this.SOLD_TICK = SOLD_TICK;
        this.DATE_HOUR = DATE_HOUR;
    }
    
    public String getEvents(String ECATEGORY_ID) {
        String sql = "SELECT";
        return sql;
    }
    
    public String create(){
        String sql = "INSERT INTO PLACE (ETYPE_ID, PLACE_ID, SOLD_TICK, DATE_HOUR)" +
                "VALUES ('" + ETYPE_ID + "', '" + PLACE_ID + "', '" + SOLD_TICK + "', '" + DATE_HOUR + "')";
        return sql;
    }
    
    public String getLastIndex(){
        String sql = "SELECT EVENT_SEQ.CURRVAL FROM DUAL";
        return sql;
    }
}