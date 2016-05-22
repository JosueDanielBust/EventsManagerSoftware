package Mundo.Admin;

public class Occupation {
    String OCCUPATION_ID, PERSON_OCCUPATION;
    public Occupation() {}
    
    public String getOccupations(){
        String sql = "SELECT PERSON_OCCUPATION FROM OCCUPATION";
        return sql;
    }
    
    public String getID(String PERSON_OCCUPATION){
        String sql = "SELECT OCCUPATION_ID FROM OCCUPATION WHERE PERSON_OCCUPATION = " + PERSON_OCCUPATION;
        return sql;
    }
    
    public String getOccupation(String PERSON_ID){
        String sql = "SELECT PERSON_OCCUPATION FROM OCCUPATION O INNER JOIN PERSON P" +
                "ON O.OCCUPATION_ID = P.OCCUPATION_ID AND P.PERSON_ID = " + PERSON_ID;
        return sql;
    }
    
    public String remove(String OCCUPATION_ID){
        String sql = "DELETE FROM OCCUPATION WHERE OCCUPATION_ID = " + OCCUPATION_ID;
        return sql;
    }
}
