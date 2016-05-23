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
public class Place {
    
    private static String PLACE_ID;

    public static String getPLACE_ID() {
        return PLACE_ID;
    }

    public static void setPLACE_ID(String PLACE_ID) {
        Place.PLACE_ID = PLACE_ID;
    }    
    
    public static String getPlaces(String PTYPE, String CITY) {
        return  " SELECT DISTINCT PLACE_NAME FROM PLACE P" +
                " INNER JOIN PLACE_TYPE PT ON P.PTYPE_ID = PT.PTYPE_ID" +
                " AND PLACE_TYPE = '" + PTYPE + "'" +
                " INNER JOIN CITY C ON P.CITY_ID = C.CITY_ID " +
                " AND C.CITY_NAME = '" + CITY + "'";
    }
    
    public static String getAddress(String PLACE_NAME,String PTYPE, String CITY) {
        return  " SELECT PLACE_ADDRESS FROM PLACE" +
                " INNER JOIN PLACE_TYPE ON PLACE.PTYPE_ID = PLACE_TYPE.PTYPE_ID" + 
                " AND PLACE_TYPE.PLACE_TYPE = '" + PTYPE + "'" +
                " AND PLACE.PLACE_NAME = '" + PLACE_NAME + "'" +
                " INNER JOIN CITY ON PLACE.CITY_ID = CITY.CITY_ID " +
                " AND CITY_NAME = '" + CITY + "'";
    }
    
}
