
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;

import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Transient;


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
@javax.persistence.Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    
    @OneToMany(mappedBy="user", targetEntity = Liczniki.class)
    @MapKey(name="poprawne")
    private Map<String, Liczniki> mapaWynikow;

    private Credentials credentials;

    public User(Credentials Cr, HashMap mapa) {
        id = new Long(0);
        credentials = Cr;
        mapaWynikow = mapa;
    }

    public User(Credentials Cr) {
        id = new Long(0);
        credentials = Cr;
        mapaWynikow = new HashMap<String, Liczniki>();
        mapaWynikow.put(Kategoria.Sztuka, new Liczniki(1, 2));
        mapaWynikow.put(Kategoria.Historia, new Liczniki(7, 8));
        mapaWynikow.put(Kategoria.Sport, new Liczniki(2, 4));
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Credentials getCredentials() {
        return credentials;
    }
    
    public Map<String, Liczniki> getMapaWynikow() {
        return mapaWynikow;
    }

    public void setMapaWynikow(Map<String, Liczniki> mapaWynikow) {
        this.mapaWynikow = (HashMap<String, Liczniki>)mapaWynikow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HashMap dodajOdpowiedzi(String kat, int poprawneOdpowiedzi, int zle) {
        Iterator<Map.Entry<String, Liczniki>> entries = mapaWynikow.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Liczniki> entry = entries.next();
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
        return (HashMap)mapaWynikow;
    }

}
