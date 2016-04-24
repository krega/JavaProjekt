/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import javafx.util.Pair;

/**
 *
 * @author Kamil
 */
public class FileCredentialHandler implements ICredentialHandler {

    private Credentials Cr;
    private HashMap<String, User> passmap;
    static String sciezka;

    public FileCredentialHandler(Credentials cr, HashMap pass) {
        Cr = cr;

        passmap = pass;
        sciezka = "C:\\Users\\Kamil\\Documents\\NetBeansProjects\\Logowanie\\Logowanie_2\\Logowanie_2\\plik.txt";
    }

    FileCredentialHandler() {

        passmap = new HashMap<String, User>();

        sciezka = "C:\\Users\\Kamil\\Documents\\NetBeansProjects\\Logowanie\\Logowanie_2\\Logowanie_2\\plik.txt";
    }

    @Override
    public HashMap Odczyt() throws FileNotFoundException {

        File file = new File(sciezka);
        Scanner odczyt = new Scanner(file);
        StringTokenizer token;
        String l, u, lp1, lp2, lp3, lp4, lp5, lp6, lp7, lp8, lp9, lp10;

        HashMap<String, Liczniki> mapaWynikow = new HashMap();
        while (odczyt.hasNextLine()) {

            token = new StringTokenizer(odczyt.nextLine(), "|");
            l = token.nextToken();
            u = token.nextToken();
            lp1 = token.nextToken();
            lp2 = token.nextToken();
            Liczniki pair1 = new Liczniki(Integer.parseInt(lp1), Integer.parseInt(lp2));
            mapaWynikow.put(Kategoria.Historia, pair1);
            lp3 = token.nextToken();
            lp4 = token.nextToken();
            Liczniki pair2 = new Liczniki(Integer.parseInt(lp3), Integer.parseInt(lp4));
            mapaWynikow.put(Kategoria.Literatura, pair2);
            lp5 = token.nextToken();
            lp6 = token.nextToken();
            Liczniki pair3 = new Liczniki(Integer.parseInt(lp5), Integer.parseInt(lp6));
            mapaWynikow.put(Kategoria.Polityka, pair3);
            lp7 = token.nextToken();
            lp8 = token.nextToken();
            Liczniki pair4 = new Liczniki(Integer.parseInt(lp7), Integer.parseInt(lp8));
            mapaWynikow.put(Kategoria.Sport, pair4);
            lp9 = token.nextToken();
            lp10 = token.nextToken();
            Liczniki pair5 = new Liczniki(Integer.parseInt(lp9), Integer.parseInt(lp10));
            mapaWynikow.put(Kategoria.Sztuka, pair5);
            Credentials cr = new Credentials(l, u);

            User user = new User(cr, mapaWynikow);
            passmap.put(l, user);
        }
        return passmap;
    }

    @Override
    public void zapisNowegoUzytkownika(Credentials Cr1) throws IOException {
        Sprawdz_String ss = new Sprawdz_String(Cr1.getHaslo());
        boolean sprawdz_String = ss.sprawdzString();
        if (sprawdz_String == true) {
            FileWriter napisz = new FileWriter(sciezka, true);
            BufferedWriter bw = new BufferedWriter(napisz);
            for (int y = 0; y < Cr1.getLogin().length(); y++) {
                bw.write(Cr1.getLogin().charAt(y));
            }
            bw.write("|");
            for (int x = 0; x < Cr1.getHaslo().length(); x++) {
                bw.write(Cr1.getHaslo().charAt(x));
            }
            for (int e = 0; e < 10; e++) {
                bw.write("|");
                bw.write("0");
            }

            bw.newLine();
            bw.close();
            napisz.close();
        }
    }

    @Override
    public void zapiszWynik() throws IOException {
        File file = new File(sciezka);
        FileWriter napisz = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(napisz);
        Iterator<Map.Entry<String, User>> entries = passmap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, User> entry = entries.next();
            Object key = entry.getValue().getCredentials().getLogin();
            bw.write(key.toString());
            bw.write("|");
            Object value = entry.getValue().getCredentials().getHaslo();
            bw.write(value.toString());
            bw.write("|");

            Iterator<Map.Entry<String, Liczniki>> entries2 = entry.getValue().getMapaWynikow().entrySet().iterator();
//              Iterator<Map.Entry<Kategoria,Pair>>entries2=entry.getValue().getMapaWynikow().entrySet().iterator();
            while (entries2.hasNext()) {
                Map.Entry<String, Liczniki> entry2 = entries2.next();
                Object key2 = entry2.getValue().getPoprawne();
                Object value2 = entry2.getValue().getNiepoprawne();
                bw.write(key2.toString());
                bw.write("|");
                bw.write(value2.toString());
                bw.write("|");

            }
            bw.newLine();

        }

        bw.close();
        napisz.close();

    }
}
