
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
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
public class Losowanie {
    // Lista liczb

    private List<Integer> liczby;

    // wielkość początkowa
    private Integer size;

    // inicjacja obiektu
    public void init() {
        // tworzymy zbiór liczb
        liczby = new LinkedList<Integer>();
        // dodajemy kolejne liczby do zbioru
        for (int i = 0; i < size; i++) {
            liczby.add(new Integer(i));
        }
    }

    // losowanie
    public Integer get() {
        do {
            if (liczby.size() == 1) {
                return liczby.get(0);
            }
            Random r = new Random();

            int i = r.nextInt(liczby.size());

            if (size == 0) {
                JOptionPane.showMessageDialog(null, "Nie ma wiecej pytan z tej kategorii, wybierz inna");

                return -1;
            }
            if (liczby.get(i).equals(i)) {
                liczby.remove(i);
                liczby.size();

                //  this.size=liczby.size();
                return i;
            }
        } while (liczby.size() > 1);
        return -1;
    }

    // zwraca wielkość zbioru
    private Integer getSize() {
        return size;
    }

    // konstruktor jako parametr przyjmujw wielkość zbioru.
    public Losowanie(Integer size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Wielkość musi być większa od 0");
        }
        this.size = size;
        init();
    }

}
