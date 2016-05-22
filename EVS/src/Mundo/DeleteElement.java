/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mundo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Julian
 */
public class DeleteElement {
     
    private static final HashMap<String,String> elementos = new HashMap<String,String>(){{
            put("CITY","CITY_NAME" );
            put("EPS","EPS");
            put("OCCUPATION","PERSON_OCCUPATION" );
            put("EVENT_CATEGORY","ECATEGORY" );
            put("PLACE_TYPE","PLACE_TYPE" );
        
    }};
    
    public static String consultarElementos(String tabla){
        return("SELECT * FROM "+tabla);   
    }
   
    public static String eliminarElemento(String tabla,String elemento){
        return ("DELETE FROM " + tabla + " WHERE " + elementos.get(tabla) + " = " + elemento);
    }    
    
}
