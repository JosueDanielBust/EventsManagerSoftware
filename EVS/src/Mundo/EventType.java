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

public class EventType {
    
    private static String ETYPE_ID;

    public static String getETYPE_ID() {
        return ETYPE_ID;
    }

    public static void setETYPE_ID(String ETYPE_ID) {
        EventType.ETYPE_ID = ETYPE_ID;
    }
    
    
    public static String getETypeNames(String category){
        return " SELECT ETYPE_NAME FROM EVENT_TYPE"+
               " INNER JOIN EVENT_CATEGORY ON EVENT_TYPE.ECATEGORY_ID = EVENT_CATEGORY.ECATEGORY_ID"+
               " AND EVENT_CATEGORY.ECATEGORY = '" + category + "'";
    }
    
    public static String getAllNames(){
        return " SELECT DISTINCT ETYPE_NAME FROM EVENT_TYPE";
    }
    
}
