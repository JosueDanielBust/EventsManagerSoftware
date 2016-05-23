package Mundo.Admin;

public class EventCategory {
    String ECATEGORY_ID, ECATEGORY;
    
    public EventCategory(){}
    
    public String getCategories() {
        String sql = "SELECT ECATEGORY FROM EVENT_CATEGORY";
        return sql;
    }
    
    public String getID(String ECATEGORY){
        String sql = "SELECT ECATEGORY_ID FROM EVENT_CATEGORY WHERE ECATEGORY = " + ECATEGORY;
        return sql;
    }
}