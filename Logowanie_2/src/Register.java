/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author Kamil
 */
public class Register implements INewUser, ILogin {

    Credentials Cr;
    private String sciezka;
    HashMap<String, String> passmap = new HashMap<String, String>();

    public Register(Credentials cr) {
        Cr = cr;

        sciezka = "C:\\Users\\Kamil\\Documents\\NetBeansProjects\\Logowanie\\JavaProjekt\\Logowanie_2\\plik.txt";

    }

    public Register(String plik_sciezka) {
        sciezka = plik_sciezka;
    }

    FileOutputStream fos = null;

    @Override
    public HashMap Odczyt() throws FileNotFoundException {

        File file = new File(sciezka);
        Scanner odczyt = new Scanner(file);
        StringTokenizer token;
        String v, k;

        while (odczyt.hasNextLine()) {
            token = new StringTokenizer(odczyt.nextLine(), "|");
            v = token.nextToken();
            k = token.nextToken();

            passmap.put(v, k);
        }
       return passmap;
    }

    @Override
    public Boolean saveNewUser(Credentials Cr) {
        try {
            FileWriter napisz = new FileWriter(sciezka, true);
            BufferedWriter bw = new BufferedWriter(napisz);
            for (int x = 0; x < Cr.getHaslo().length(); x++) {
                bw.write(Cr.getHaslo().charAt(x));
            }
            bw.write("|");
            for (int y = 0; y < Cr.getLogin().length(); y++) {
                bw.write(Cr.getLogin().charAt(y));
            }
            bw.newLine();
            bw.close();
            napisz.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Rejestracja przebiegla nieprawidlowo");
            return false;
        }

    }
}
