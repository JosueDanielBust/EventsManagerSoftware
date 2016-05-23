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
public class PlaceType {
    
    public static String getPlacesTypesOfCity(String CITY) {
        return  " SELECT DISTINCT PLACE_TYPE FROM PLACE_TYPE PT" +
                " INNER JOIN PLACE P ON PT.PTYPE_ID = P.PTYPE_ID" +
                " INNER JOIN CITY C ON P.CITY_ID = C.CITY_ID " + 
                " AND C.CITY_NAME = '" + CITY + "'";
    }
    
    public static String getAllPlaceTypes(){
        return  " SELECT DISTINCT PLACE_TYPE FROM PLACE_TYPE";
    }
    
}
