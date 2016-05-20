/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

/**
 *
 * @author Nicolas
 */
public class Person {
    
    private final String PERSON_ID;
    
    private String PERSON_NAME;
    
    private String PERSON_EMAIL;
    
    private String PERSON_PHONE;
    
    private String PERSON_ADDRESS;
    
    private String EPS;
    
    private String OCCUPATION;
    
    
    public Person(String PERSON_ID,String PERSON_NAME,String PERSON_EMAIL,String PASSWORD,String PERSON_PHONE,String PERSON_ADDRESS,String EPS,String OCCUPATION){
        this.PERSON_ID = PERSON_ID;
        this.PERSON_NAME = PERSON_NAME;
        this.PERSON_EMAIL = PERSON_EMAIL;
        this.PERSON_PHONE = PERSON_PHONE;
        this.PERSON_ADDRESS = PERSON_ADDRESS;
        this.EPS = EPS;
        this.OCCUPATION = OCCUPATION;
    }
    
    public String getPERSON_ID() {
        return PERSON_ID;
    }

    public String getPERSON_NAME() {
        return PERSON_NAME;
    }

    public String getPERSON_EMAIL() {
        return PERSON_EMAIL;
    }

    public String getPERSON_PHONE() {
        return PERSON_PHONE;
    }

    public String getPERSON_ADDRESS() {
        return PERSON_ADDRESS;
    }

    public String getEPS() {
        return EPS;
    }

    public String getOCCUPATION() {
        return OCCUPATION;
    }

    public void setPERSON_NAME(String PERSON_NAME) {
        this.PERSON_NAME = PERSON_NAME;
    }

    public void setPERSON_EMAIL(String PERSON_EMAIL) {
        this.PERSON_EMAIL = PERSON_EMAIL;
    }

    public void setPERSON_PHONE(String PERSON_PHONE) {
        this.PERSON_PHONE = PERSON_PHONE;
    }

    public void setPERSON_ADDRESS(String PERSON_ADDRESS) {
        this.PERSON_ADDRESS = PERSON_ADDRESS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public void setOCCUPATION(String OCCUPATION) {
        this.OCCUPATION = OCCUPATION;
    }
    
    
    
}
