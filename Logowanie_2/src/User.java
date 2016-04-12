
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
    private HashMap<Kategoria, Liczniki> mapaWynikow;
    private Map mapaWynikowS;

    public Map getMapaWynikowS() {
        return mapaWynikowS;
    }

    public void setMapaWynikowS(Map mapaWynikowS) {
        this.mapaWynikowS = mapaWynikowS;
    }
    private Credentials credentials;

    public User(Credentials Cr, HashMap mapa) {
        id = new Long(0);
        credentials = Cr;
        mapaWynikow = mapa;
    }

    public User() {
        id = new Long(0);
        mapaWynikowS = new HashMap<String, Liczniki>();
        mapaWynikowS.put("Sztuka", new Liczniki(1,2));
        mapaWynikowS.put("Historia", new Liczniki(7,8));
        mapaWynikowS.put("Sport", new Liczniki(2,4));
    }

    public User(Credentials Cr) {
        id = new Long(0);
        credentials = Cr;
        mapaWynikow = new HashMap<Kategoria, Liczniki>();
        mapaWynikow.put(Kategoria.Sztuka, new Liczniki(1,2));
        mapaWynikow.put(Kategoria.Historia, new Liczniki(7,8));
        mapaWynikow.put(Kategoria.Sport, new Liczniki(2,4));
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public HashMap<Kategoria, Liczniki> getMapaWynikow() {
        return mapaWynikow;
    }

    public void setMapaWynikow(HashMap<Kategoria, Liczniki> mapaWynikow) {
        this.mapaWynikow = mapaWynikow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HashMap dodajOdpowiedzi(Kategoria kat, int poprawneOdpowiedzi, int zle) {
        Iterator<Map.Entry<Kategoria, Liczniki>> entries = mapaWynikow.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Kategoria, Liczniki> entry = entries.next();
            Object key = entry.getKey();
            if (key.equals(kat)) {
                Object value = entry.getValue().getNiepoprawne();
                int punkt = Integer.parseInt(value.toString());
                punkt = punkt + poprawneOdpowiedzi;
                value = Integer.parseInt(value.toString()) + punkt;
                Object keyy = entry.getValue().getPoprawne();
                int zlaOdpowiedz = Integer.parseInt(keyy.toString());
                zlaOdpowiedz = zlaOdpowiedz + zle;
                mapaWynikow.remove(key, value);
                Liczniki pair = new Liczniki(punkt, zlaOdpowiedz);
                mapaWynikow.put(kat, pair);
            }
        }
        return mapaWynikow;
    }

    
}
