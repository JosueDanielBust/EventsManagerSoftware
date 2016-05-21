/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import MainInterfaces.DBAccess;
import java.sql.SQLException;

/**
 *
 * @author Nicolas
 */
public class Person {
    
    private static String PERSON_ID;

    public static String getPERSON_ID() {
        return PERSON_ID;
    }

    public static void setPERSON_ID(String PERSON_ID) {
        Person.PERSON_ID = PERSON_ID;
    }
    
    public static String consultarPassword_Id(DBAccess dba,String correoElectronico) throws SQLException{
        return "SELECT PASSWORD,PERSON_ID FROM PERSON WHERE PERSON_EMAIL = '"+correoElectronico+"'";
    }
    
    
    
}
