
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class OdczytZPliku implements ILogin {
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
