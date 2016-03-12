
/*ader, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class Pytanie {
   
    private Kategoria kategoria;
    public String tresc,odp1,odp2,odp3,odp4;
    
   
    private int poprawnaOdpowiedz;

  public Pytanie(){}
   
    public Pytanie(String [] pyt) 
    {
        tresc= pyt[0];
        odp1=pyt[1];
        odp2=pyt[2];
        odp3=pyt[3];
        odp4=pyt[4];
        poprawnaOdpowiedz=1;
         
    }
}
