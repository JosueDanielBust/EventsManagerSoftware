package Mundo.Admin;

public class Place {
    private String PLACE_ID, PLACE_NAME, PLACE_PHONE, ACCESS_RESTRICTIONS, PLACE_ADDRESS, CAPACITY, PTYPE_ID, CITY_ID;
    
    public Place(){}
    public Place(String PLACE_NAME, String PLACE_PHONE,
            String ACCESS_RESTRICTIONS, String PLACE_ADDRESS, String CAPACITY,
            String PTYPE_ID, String CITY_ID) {
        this.PLACE_NAME = PLACE_NAME;
        this.PLACE_PHONE = PLACE_NAME;
        this.ACCESS_RESTRICTIONS = ACCESS_RESTRICTIONS;
        this.PLACE_ADDRESS = PLACE_ADDRESS;
        this.CAPACITY = CAPACITY;
        this.PTYPE_ID = PTYPE_ID;
        this.CITY_ID = CITY_ID;
    }
    public Place(String PLACE_ID, String PLACE_NAME, String PLACE_PHONE,
            String ACCESS_RESTRICTIONS, String PLACE_ADDRESS, String CAPACITY,
            String PTYPE_ID, String CITY_ID) {
        this.PLACE_ID = PLACE_ID;
        this.PLACE_NAME = PLACE_NAME;
        this.PLACE_PHONE = PLACE_NAME;
        this.ACCESS_RESTRICTIONS = ACCESS_RESTRICTIONS;
        this.PLACE_ADDRESS = PLACE_ADDRESS;
        this.CAPACITY = CAPACITY;
        this.PTYPE_ID = PTYPE_ID;
        this.CITY_ID = CITY_ID;
    }
    
    public String update() {
        String sql = "UPDATE PLACE SET PLACE_NAME = " + PLACE_NAME + ", PLACE_PHONE = " + PLACE_PHONE +
                ", ACCESS_RESTRICTIONS = " + ACCESS_RESTRICTIONS + ", PLACE_ADDRESS = " + PLACE_ADDRESS +
                ", CAPACITY = " + CAPACITY + ", PTYPE_ID = " + PTYPE_ID + ", CITY_ID = " + CITY_ID +
                " WHERE PLACE_ID = " + PLACE_ID;
        return sql;
    }
    
    public String create() {
        String sql = "INSERT INTO PLACE (PLACE_NAME, PLACE_PHONE, ACCESS_RESTRICTIONS, PLACE_ADDRESS, CAPACITY, PTYPE_ID, CITY_ID)" +
                "VALUES ('" + PLACE_NAME + "', '" + PLACE_PHONE + "', '" + ACCESS_RESTRICTIONS + "', '" + PLACE_ADDRESS + "', '" +
                CAPACITY + "', '" + PTYPE_ID + "', '" + CITY_ID + "')";
        return sql;
    }
    
    public String remove(String PLACE_ID) {
        String sql = "DELETE FROM PLACE WHERE PLACE_ID = " + PLACE_ID;
        return sql;
    }
    
    public String getID(String CITY_NAME){
        String sql = "SELECT CITY_ID FROM CITY WHERE CITY_NAME = " + CITY_NAME;
        return sql;
    }
    
    public String getID(String CITY_ID, String PTYPE_ID, String PLACE_NAME) {
        String sql = "SELECT PLACE_ADDRESS FROM PLACE P" +
                "INNER JOIN PLACE_TYPE PT ON P.PTYPE_ID = PT.PTYPE_ID AND P.PTYPE_ID = " + PTYPE_ID +
                "INNER JOIN CITY C ON P.CITY_ID = C.CITY_ID AND C.CITY_ID = " + CITY_ID +
                "AND P.PLACE_NAME = '" + PLACE_NAME + "'";
        return sql;
    }
    
    public String getPlaces() {
        String sql = "SELECT PLACE_NAME FROM PLACE";
        return sql;
    }
    
    public String getPlaces(String CITY_ID){
        String sql = "SELECT PLACE_NAME FROM PLACE P INNER JOIN CITY C" +
                "ON C.CITY_ID = P.CITY_ID AND P.CITY_ID = " + CITY_ID;
        return sql;
    }
    
    public String getPlaces(String PTYPE_ID, String CITY_ID) {
        String sql = "SELECT PLACE_NAME FROM PLACE P" +
                "INNER JOIN PLACE_TYPE PT ON P.PTYPE_ID = PT.PTYPE_ID AND P.PTYPE_ID = " + PTYPE_ID +
                "INNER JOIN CITY C ON P.CITY_ID = C.CITY_ID AND C.CITY_ID = " + CITY_ID +
                "GROUP BY P.PLACE_NAME";
        return sql;
    }
    
    public String getName(String PLACE_ID){
        String sql = "SELECT PLACE_NAME FROM PLACE WHERE PLACE_ID = " + PLACE_ID;
        return sql;
    }
    
    public String getPhone(String PLACE_ID){
        String sql = "SELECT PLACE_PHONE FROM PLACE WHERE PLACE_ID = " + PLACE_ID;
        return sql;
    }
    
    public String getRestrictions(String PLACE_ID){
        String sql = "SELECT ACCESS_RESTRICTIONS FROM PLACE WHERE PLACE_ID = " + PLACE_ID;
        return sql;
    }
    
    public String getAddress(String PLACE_ID) {
        String sql = "RETURN PLACE_ADDRESS FROM PLACE WHERE PLACE_ID = " + PLACE_ID;
        return sql;
    }
    
    public String getCapacity(String PLACE_ID){
        String sql = "SELECT CAPACITY FROM PLACE WHERE PLACE_ID = " + PLACE_ID;
        return sql;
    }
    
    public String getPType(String PLACE_ID){
        String sql = "SELECT PLACE_TYPE FROM PLACE_TYPE PT INNER JOIN PLACE P" +
                "ON P.PTYPE_ID = PT.PTYPE_ID AND P.PLACE_ID = " + PLACE_ID;
        return sql;
    }
    
    public String getCity(String PLACE_ID){
        String sql = "SELECT CITY_NAME FROM CITY C INNER JOIN PLACE P" +
                "ON C.CITY_ID = P.CITY_ID AND P.PLACE_ID = " + PLACE_ID;
        return sql;
    }
}