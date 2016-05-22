package Mundo.Admin;

public class EPS {
    String EPS_ID, EPS;
    
    public EPS(){}
    
    public String getEPSs() {
        String sql = "SELECT EPS FROM EPS";
        return sql;
    }
    
    public String getID(String EPS){
        String sql = "SELECT EPS_ID FROM EPS WHERE EPS = " + EPS;
        return sql;
    }
    
    public String getEPS(String PERSON_ID){
        String sql = "SELECT EPS FROM EPS E INNER JOIN PERSON P" +
                "ON E.EPS_ID = P.EPS_ID AND P.PERSON_ID = " + PERSON_ID;
        return sql;
    }
    
    public String remove(String EPS_ID){
        String sql = "DELETE FROM EPS WHERE EPS_ID = " + EPS_ID;
        return sql;
    }
}