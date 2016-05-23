package Mundo.Admin;

public class PlaceType {
    String PTYPE_ID, PLACE_TYPE;
    
    public PlaceType(){}
    
    public String getID(String PLACE_TYPE) {
        String sql = "SELECT PTYPE_ID FROM PLACE_TYPE P WHERE P.PLACE_TYPE = " + PLACE_TYPE;
        return sql;
    }
    
    public String getType(String PTYPE_ID){
        String sql = "SELECT PLACE_TYPE FROM PLACE_TYPE P WHERE P.PTYPE_ID = " + PTYPE_ID;
        return sql;
    }
    
    public String getPlacesTypes() {
        String sql = "SELECT PLACE_TYPE FROM PLACE_TYPE";
        return sql;
    }
    
    public String getPlacesTypesOfCity(String CITY_ID) {
        return  "SELECT DISTINCT PLACE_TYPE FROM PLACE_TYPE PT" +
                "INNER JOIN PLACE P ON PT.PTYPE_ID = P.PTYPE_ID" +
                "INNER JOIN CITY C ON P.CITY_ID = C.CITY_ID "
                + "AND C.CITY_ID = " + CITY_ID;
    }
}