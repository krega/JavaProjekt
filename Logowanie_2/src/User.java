
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.util.Pair;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;

/*
=======
import javax.swing.JOptionPane;

    /*
>>>>>>> bb45147f683b1290362db041a0bc49853a92989c
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kamil
 */
public class User {

    private long id;
    private HashMap<Kategoria, Pair> mapaWynikow;
    private Credentials credentials;

    public User(Credentials Cr, HashMap mapa) {
        id = new Long(0);
        credentials = Cr;
        mapaWynikow = mapa;
    }

    public User() {
        id = new Long(0);
    }

    public User(Credentials Cr) {
        id = new Long(0);
        credentials = Cr;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public HashMap<Kategoria, Pair> getMapaWynikow() {
        return mapaWynikow;
    }

    public void setMapaWynikow(HashMap<Kategoria, Pair> mapaWynikow) {
        this.mapaWynikow = mapaWynikow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
