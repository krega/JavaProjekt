/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Kamil
 */
public class Register implements INewUser, ILogin {

    Credentials Cr;

    FileOutputStream fos = null;

    public Register(Credentials cr) {
        Cr = cr;
    }

    @Override
    public Boolean saveNewUser(Credentials Cr) {
        try {
            fos = new FileOutputStream("plik.txt"); //Otwieranie pliku 

            for (int x = 0; x < Cr.getHaslo().length(); x++) {
                fos.write(Cr.getHaslo().charAt(x));
            }
            for (int i = 0; i < Cr.getLogin().length(); i++) {
                fos.write(Cr.getLogin().charAt(i));

            }

        } catch (IOException ex) {
            System.out.println("Błąd operacji na pliku: " + ex);
        }

        try {
            fos.close(); //Zamykanie pliku 
            return true;
        } catch (IOException e) {
            System.out.println("Błąd operacji na pliku: " + e);
            return false;
        }

    }

    @Override
    public String Odczyt() {
        File file = new File("Plik.txt");

        String odczyt = "";
        try {

            Scanner skaner = new Scanner(file);

            while (skaner.hasNextLine()) {

                odczyt = odczyt + skaner.nextLine() + "\n";
            }
              
        } catch (FileNotFoundException e) {
            System.out.println("Brak Pliku do odczytania!");
        }
            return odczyt;
    }

}
