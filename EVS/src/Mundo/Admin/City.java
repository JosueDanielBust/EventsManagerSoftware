package Mundo.Admin;

public class City {
    String CITY_ID, CITY_NAME;
    
    public City(){}
    
    public String getID(String CITY_NAME) {
        String sql = "SELECT CITY_ID FROM CITY C WHERE C.CITY_NAME = " + CITY_NAME;
        return sql;
    }
    
    public String getType(String CITY_ID){
        String sql = "SELECT CITY_NAME FROM CITY C WHERE C.CITY_ID = " + CITY_ID;
        return sql;
    }
    
    public String getCiudades() {
        String sql = "SELECT CITY_NAME FROM CITY";
        return sql;
    }
}