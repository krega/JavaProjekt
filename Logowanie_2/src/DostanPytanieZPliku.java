

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class DostanPytanieZPliku implements IPobierzPytanie{

   private String kategoria;
   private LinkedList listaPytan;
   private Pytanie pytanie;
   public DostanPytanieZPliku(){
       listaPytan= new LinkedList();
   pytanie=new Pytanie();
   }
   public DostanPytanieZPliku(String kare)
   {
       listaPytan=new LinkedList();
       kategoria=kare;
       pytanie=new Pytanie();
   }
   

  String rozroznijKategorie(String kate) throws FileNotFoundException
   {
       String kat=kate.toString();
       String path="C:\\Users\\Kamil\\Documents\\NetBeansProjects\\Logowanie\\Logowanie_2\\Logowanie_2\\Pytania\\";
   
     String sciezka=new String(path+kat+".txt");
       return sciezka;
   }
   public int liczbaPytan(int i)
   {
       return i;
   }
   
  @Override
   public String[] dzielString(String c)
    {
        String []tab =new String[5];
            tab= c.split(";");
           
            return tab;
    }
     
  
   
   @Override
  public LinkedList PobierzPytanie(String kategoria)throws FileNotFoundException{
        FileReader fr=null;
        String linia="";
        try{
            fr=new FileReader(rozroznijKategorie(kategoria));
        }
        catch (FileNotFoundException e) {
       System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
       System.exit(1);
   }
        BufferedReader bfr = new BufferedReader(fr);
       
   try {
     while((linia = bfr.readLine()) != null){
        
         
        Pytanie pytanie=new Pytanie((dzielString(linia)));
   
  //      System.out.println(linia);
             listaPytan.add(pytanie);
         
        
     }
    } catch (IOException e) {
        System.out.println("BŁĄD ODCZYTU Z PLIKU!");
        System.exit(2);
   }
   try {
     fr.close();
    } catch (IOException e) {
         System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
         System.exit(3);
        }

        
        return listaPytan;
    }
  
    
  
   

}
