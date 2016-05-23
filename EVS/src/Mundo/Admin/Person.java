package Mundo.Admin;

public class Person {
    String PERSON_ID, PERSON_NAME, PERSON_EMAIL, PASSWORD, PERSON_PHONE, PERSON_ADDRESS, EPS_ID, OCCUPATION_ID;

    public Person(String PERSON_ID, String OCCUPATION_ID, String EPS_ID) {
        this.PERSON_ID = PERSON_ID;
        this.OCCUPATION_ID = OCCUPATION_ID;
        this.EPS_ID = EPS_ID;
    }
    
    public String update() {
        String sql = "UPDATE PERSON SET OCCUPATION_ID = " + OCCUPATION_ID + ", EPS_ID = " + EPS_ID +
                " WHERE PERSON_ID = " + PERSON_ID;
        return sql;
    }
}
