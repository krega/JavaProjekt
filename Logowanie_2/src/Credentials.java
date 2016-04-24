
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
@Embeddable
public class Credentials {
    private String Login;
    private String Haslo;
//    private int id;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
    String getHaslo(){return Haslo;}

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public void setHaslo(String Haslo) {
        this.Haslo = Haslo;
    }
    void SetHaslo(String haslo){Haslo=haslo;}
    
    String getLogin(){return Login;}
    void SetLogin(String login){Login=login;}
    
    public Credentials( String login,String haslo){       
        Login=login;
        Haslo=haslo;
    }
    
    public Credentials(){
        Login=new String();
        Haslo=new String();
    }
    
    
    
   
    
}
