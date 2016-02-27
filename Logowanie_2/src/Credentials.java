/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class Credentials {
    
    
    private String Login;
    private String Haslo;
    String getHaslo(){return Haslo;}
    void SetHaslo(String haslo){Haslo=haslo;}
    
    String getLogin(){return Login;}
    void SetLogin(String login){Login=login;}
    
    public Credentials( String login,String haslo){
       
        Login=login;
         Haslo=haslo;
        
    }
    
    
    
   
    
}
