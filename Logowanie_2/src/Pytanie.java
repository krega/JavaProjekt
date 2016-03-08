
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.lang.String;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
/*
 * To change this license header, choose License Headers in Project Properties.
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
    
    private LinkedList mapaPytan;
    private int poprawnaOdpowiedz;

    public Pytanie()
    {
        
        pytania();
    }
    public Pytanie( LinkedList mapa, Kategoria kat) 
    {
     mapaPytan=mapa;
     kategoria=kat;
        
    }
    public Pytanie( IPobierzPytanie pobierz, Kategoria kategoria) throws FileNotFoundException
    {
          mapaPytan=pobierz.PobierzPytanie(kategoria);
          pytania();
         
    }
    public String[] dzielString(String c)
    {
        String []tab =new String[4];
            tab= c.split(";");
            for (int i=0;i<4;i++)
            {
                System.out.print(tab[i]);
            }
            return tab;
    }
    public void ustaw(String b[])
    {
        tresc=b[0];
        odp1=b[1];
        odp2=b[2];
        odp3=b[3];
        odp4=b[4];
    }
    public void pytania()
    {
        int a=losuj();
       
      int index = new Random().nextInt(size);
        for(Integer key : keys){
            if(a==key)
            {
                String pyt=mapaPytan.values().toString();
                ustaw(dzielString(pyt));
            }
        }
      
   

    }
    public int  losuj()
    {
            
            Random generator=new Random();
            int a=generator.nextInt(2);
            return generator.nextInt(1)+2;
            
    }
    
}
