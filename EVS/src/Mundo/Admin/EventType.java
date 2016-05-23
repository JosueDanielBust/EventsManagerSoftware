package Mundo.Admin;

public class EventType {
    String ETYPE_ID, ETYPE_NAME, RESTRICTIONS, ECATEGORY_ID;
    
    public EventType(){}
    public EventType(String ETYPE_NAME, String RESTRICTIONS, String ECATEGORY_ID){
        this.ETYPE_ID = ETYPE_ID;
        this.RESTRICTIONS = RESTRICTIONS;
        this.ECATEGORY_ID = ECATEGORY_ID;
    }
    
    public String getEvents(String ECATEGORY_ID) {
        String sql = "SELECT ETYPE_NAME FROM EVENT_TYPE ET INNER JOIN EVENT_CATEGORY EC" +
                "ON ET.ECATEGORY_ID = EC.ECATEGORY_ID AND EC.ECATEGORY_ID = " + ECATEGORY_ID;
        return sql;
    }
    
    public String getID(String ETYPE_NAME){
        String sql = "SELECT ETYPE_ID FROM EVENT_TYPE WHERE ETYPE_NAME = " + ETYPE_NAME;
        return sql;
    }
    
    public String getRestrictions(String ETYPE_ID) {
        String sql = "SELECT RESTRICTIONS FROM EVENT_TYPE ET INNER JOIN EVENT_CATEGORY EC" +
                "ON ET.ECATEGORY_ID = EC.ECATEGORY_ID AND ET.ETYPE_ID = " + ETYPE_ID;
        return sql;
    }
    
    public String create(){
        String sql = "INSERT INTO PLACE (ETYPE_NAME, RESTRICTIONS, ECATEGORY_ID)" +
                "VALUES ('" + ETYPE_NAME + "', '" + RESTRICTIONS + "', '" + ECATEGORY_ID + "')";
        return sql;
    }
    
    public String update(String ETYPE_ID, String RESTRICTIONS) {
        String sql = "UPDATE PLACE SET RESTRICTIONS = " + RESTRICTIONS +
                " WHERE ETYPE_ID = " + ETYPE_ID;
        return sql;
    }
    
    public String remove(String ETYPE_ID){
        String sql = "DELETE FROM EVENT_TYPE WHERE ETYPE_ID = " + ETYPE_ID;
        return sql;
    }
    
    public String getLastIndex(){
        String sql = "SELECT EVENT_TYPE_SEQ.CURRVAL FROM DUAL";
        return sql;
    }
}
