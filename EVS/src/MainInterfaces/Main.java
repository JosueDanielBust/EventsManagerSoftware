/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainInterfaces;

import Mundo.Person;

/**
 *
 * @author Nicolas
 */
public class Main {
   
    private static DBAccess DBA;
    private static Person usuario;
    private static Login login;
    
    
    
    public static void main(String[] args){
        DBA = new DBAccess();
        login = new Login(DBA);
    }
}
