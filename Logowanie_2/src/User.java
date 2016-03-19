
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.util.Pair;
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
    private HashMap<Kategoria, Pair> mapaWynikow;

    public User(Credentials Cr, HashMap mapa) {
        Credential = Cr;
        mapaWynikow = mapa;

    }

    public User(Credentials Cr) {
        Credential = Cr;
    }

    public void setMapaWynikow(HashMap mapa) {
        mapaWynikow = mapa;
    }

    public HashMap getMapaWynikow() {
        return mapaWynikow;
    }

    public Credentials getCredential() {
        return Credential;
    }

    public HashMap dodajOdpowiedzi(Kategoria kat, int poprawneOdpowiedzi, int zle) {
        Iterator<Map.Entry<Kategoria, Pair>> entries = mapaWynikow.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Kategoria, Pair> entry = entries.next();
            Object key = entry.getKey();
            if (key.equals(kat)) {
                Object value = entry.getValue().getValue();
                int punkt = Integer.parseInt(value.toString());
                punkt = punkt + poprawneOdpowiedzi;
                value = Integer.parseInt(value.toString()) + punkt;
                Object keyy = entry.getValue().getKey();
                int zlaOdpowiedz = Integer.parseInt(keyy.toString());
                zlaOdpowiedz = zlaOdpowiedz + zle;
                mapaWynikow.remove(key, value);
                Pair pair = new Pair(punkt, zlaOdpowiedz);
                mapaWynikow.put(kat, pair);
            }
        }
        return mapaWynikow;
    }

}
