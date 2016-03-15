
import javax.swing.JOptionPane;

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class User {
    
    
    private Credentials Credential;
    private int poprawnaOdpowiedzPolityka;
    private int niepoprawnaOdpowiedzPolityka;
    private int poprawnaOdpowiedzHistoria;
    private int niepoprawnaOdpowiedzHistoria;
    private int poprawnaOdpowiedzSport;
    private int niepoprawnaOdpowiedzSport;
    private int poprawnaOdpowiedzLiteratura;
    private int niepoprawnaOdpowiedzLiteratura;
    private int poprawnaOdpowiedzSztuka;
    private int niepoprawnaOdpowiedzSztuka;
    
    public User(Credentials Cr)
    {
         Credential=Cr;
         
        
    }
    public void dodajPoprawnaOdpowiedz(Kategoria kat)
    {
        if(kat.toString()=="Polityka")
        {
            poprawnaOdpowiedzPolityka++;
        }
       else if(kat.toString()=="Historia")
        {
            poprawnaOdpowiedzHistoria++;
        }
      else  if(kat.toString()=="Sport")
        {
            poprawnaOdpowiedzSport++;
        }
      else  if(kat.toString()=="Literatura")
        {
            poprawnaOdpowiedzLiteratura++;
        }
       else if(kat.toString()=="Sztuka")
        {
            poprawnaOdpowiedzSztuka++;
        }
       else 
       {
           JOptionPane.showMessageDialog(null, "Blad, nie wyszukano kategorii (user)");

       }
    }
    public void dodajNiepoprawnaOdpowiedz(Kategoria kat)
    {
        {
        if(kat.toString()=="Polityka")
        {
            niepoprawnaOdpowiedzPolityka++;
        }
       else if(kat.toString()=="Historia")
        {
            niepoprawnaOdpowiedzHistoria++;
        }
      else  if(kat.toString()=="Sport")
        {
            niepoprawnaOdpowiedzSport++;
        }
      else  if(kat.toString()=="Literatura")
        {
            niepoprawnaOdpowiedzLiteratura++;
        }
       else if(kat.toString()=="Sztuka")
        {
            niepoprawnaOdpowiedzSztuka++;
        }
       else 
       {
           JOptionPane.showMessageDialog(null, "Blad, nie wyszukano kategorii (user)");

       }
    }
    }
    
    
}
