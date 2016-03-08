

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class DostanPytanie implements IPobierzPytanie{

   private Kategoria kategoria;
   private LinkedList mapa;
   public DostanPytanie(){mapa= new LinkedList();}
   public DostanPytanie(Kategoria kare)
   {
       mapa=new LinkedList();
       kategoria=kare;
   }
   

  String rozroznijKategorie(Kategoria kate) throws FileNotFoundException
   {
       String kat=kate.toString();
   
     return "C:\\Users\\Kamil\\Documents\\NetBeansProjects\\Logowanie\\JavaProjekt\\Logowanie_2\\Pytania\\"+kat+".txt";
   }
   
   
   @Override
  public LinkedList PobierzPytanie(Kategoria kategoria)throws FileNotFoundException{
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
        // ODCZYT KOLEJNYCH LINII Z PLIKU:
   try {
     while((linia = bfr.readLine()) != null){
         String linia2=linia;
        
   
        System.out.println(linia);
             mapa.add(linia);
        
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

        
        return mapa;
    }

}
