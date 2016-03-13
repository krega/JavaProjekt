
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


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

    private List<Integer> liczby;

    private Integer size;

    public void init() {

        liczby = new LinkedList<Integer>();

        for (int i = 0; i < size; i++) {
            liczby.add(new Integer(i));
        }
    }

    public Integer get() {
        do {
            if (liczby.size() == 1) {
                int c = liczby.get(0);
                liczby.remove(0);
                return c;

            }
            if (liczby.size() == 0) {
                //  JOptionPane.showMessageDialog(null, "Nie ma wiecej pytan z tej kategorii, wybierz inna");

                return -1;
            }
            Random r = new Random();

            int i = r.nextInt(liczby.size());

            int a = liczby.get(i);
            if (liczby.contains(a)) {
                liczby.remove(i);
                return i;
            }
        } while (liczby.size() > 1);

        return -1;

    }

    private Integer getSize() {
        return size;
    }

    public Losowanie(Integer size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Wielkość musi być większa od 0");
        }
        this.size = size;
        init();
    }

}
