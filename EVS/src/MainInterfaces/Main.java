/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainInterfaces;
import ClientInterfaces.*;
/**
 *
 * @author Nicolas
 */
public class Main {
      
    
    public static void main(String[] args){
        DBAccess.conectar();
        new Login();
    }
}
