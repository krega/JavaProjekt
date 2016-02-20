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
    
    private String Haslo;
    private String Login;
    String getHaslo(){return Haslo;}
    void SetHaslo(String haslo){Haslo=haslo;}
    
    String getLogin(){return Login;}
    void SetLogin(String login){Login=login;}
    
    public Credentials(String haslo, String login){
       
        Login=login;
         Haslo=haslo;
        
    }
    
    
    
   
    
}
