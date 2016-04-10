    
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kamil
 */
public class Okno_Pytania implements ActionListener {

    private JTextArea pytanieArea;
    private JButton odpowiedz_1Button, odpowiedz_2Button, odpowiedz_3Button, odpowiedz_4Button;
    private JFrame panelFrame;
    private LinkedList listaPytan;
    private Pytanie pytanie;
    private Kategoria kategoria;
    private Losowanie losowanie;
    private User user;
    private List<JButton> listaPrzyciskow = new ArrayList<JButton>();
    private int poprawneOdpowiedzi, zleOdpowiedzi;
    private ICredentialHandler hndl;


    public Okno_Pytania(IPobierzPytanie pytanie, Kategoria kat, User us,ICredentialHandler hand) throws FileNotFoundException, IOException {
        user=us;
        poprawneOdpowiedzi=0;
        zleOdpowiedzi=0;

        kategoria = kat;
        listaPytan = pytanie.PobierzPytanie(kategoria);
        losowanie = new Losowanie(listaPytan.size());
        ustawPytanie();
        hndl=hand;
        initJFramePanelFrame();
        initJTextAreaPytanie();
        initButtonsOdpowiedzi();
        initListaPrzyciskow();
        zmianaPytania();
        panelFrame.setVisible(true);

    }

    private void initListaPrzyciskow() {
        listaPrzyciskow.add(odpowiedz_1Button);
        listaPrzyciskow.add(odpowiedz_2Button);
        listaPrzyciskow.add(odpowiedz_3Button);
        listaPrzyciskow.add(odpowiedz_4Button);
    }

    private void initButtonsOdpowiedzi() {
        initJButtonOdpowiedz_1();
        initJButtonOdpowiedz_2();
        initJButtonOdpowiedz_3();
        initJButtonOdpowiedz_4();
    }

    private void initJFramePanelFrame() {
        panelFrame = new JFrame("Okno pytania");
        panelFrame.setLayout(null);
        panelFrame.setBounds(800, 800, 800, 800);
        panelFrame.setSize(new Dimension(500, 500));
        panelFrame.setLocation(100, 100);

    }

   
    public Pytanie ustawPytanie() throws IOException {
        int a = losowanie.get();
        if (a == -1) {
            JOptionPane.showMessageDialog(null, "Koniec pytan w tej kategorii");
            user.setMapaWynikow(user.dodajOdpowiedzi(kategoria, poprawneOdpowiedzi,zleOdpowiedzi));
            hndl.zapiszWynik();
            panelFrame.dispose();
            poprawneOdpowiedzi=0;
            zleOdpowiedzi=0;
        }
        pytanie = (Pytanie) (listaPytan.get(a));

        return pytanie;

    }

    private void initJButtonOdpowiedz_1() {
        odpowiedz_1Button = new JButton(pytanie.odp1);
        odpowiedz_1Button.setLayout(null);
        odpowiedz_1Button.setBounds(10, 200, 200, 50);
        panelFrame.add(odpowiedz_1Button);
        odpowiedz_1Button.addActionListener(this);

    }

    private void initJButtonOdpowiedz_3() {
        odpowiedz_3Button = new JButton(pytanie.odp3);
        odpowiedz_3Button.setLayout(null);
        odpowiedz_3Button.setBounds(250, 200, 200, 50);
        panelFrame.add(odpowiedz_3Button);
        odpowiedz_3Button.addActionListener(this);
    }

    private void initJButtonOdpowiedz_4() {
        odpowiedz_4Button = new JButton(pytanie.odp4);
        odpowiedz_4Button.setLayout(null);
        odpowiedz_4Button.setBounds(250, 300, 200, 50);
        panelFrame.add(odpowiedz_4Button);
        odpowiedz_4Button.addActionListener(this);
    }

    private void initJButtonOdpowiedz_2() {
        odpowiedz_2Button = new JButton(pytanie.odp2);
        odpowiedz_2Button.setLayout(null);
        odpowiedz_2Button.setBounds(10, 300, 200, 50);
        panelFrame.add(odpowiedz_2Button);
        odpowiedz_2Button.addActionListener(this);

    }

    private void initJTextAreaPytanie() {

        pytanieArea = new JTextArea(pytanie.tresc);
        pytanieArea.setLayout(null);
        pytanieArea.setBounds(10, 10, 20, 20);
        pytanieArea.setSize(450, 150);
        panelFrame.add(pytanieArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == odpowiedz_1Button) {
            if (odpowiedz_1Button.getText().equals(pytanie.odp1)) {

                JOptionPane.showMessageDialog(null, "Poprawna odpowiedz");
                poprawneOdpowiedzi++;
                
            } else {
                JOptionPane.showMessageDialog(null, "NiePoprawna odpowiedz");
                zleOdpowiedzi++;
            }
            try {
                ustawPytanie();
            } catch (IOException ex) {
                Logger.getLogger(Okno_Pytania.class.getName()).log(Level.SEVERE, null, ex);

            } 
           
                zmianaPytania();
            
         
        }
        if (src == odpowiedz_2Button) {
            if (odpowiedz_2Button.getText().equals(pytanie.odp1)) {
                JOptionPane.showMessageDialog(null, "Poprawna odpowiedz");

                poprawneOdpowiedzi++;
            } else {
                JOptionPane.showMessageDialog(null, "NiePoprawna odpowiedz");
                      zleOdpowiedzi++;
         
            }
            try {
                ustawPytanie();
            } catch (IOException ex) {
                Logger.getLogger(Okno_Pytania.class.getName()).log(Level.SEVERE, null, ex);

              
            }
            zmianaPytania();
            }
          
        
        if (src == odpowiedz_3Button) {
            if (odpowiedz_3Button.getText().equals(pytanie.odp1)) {
                JOptionPane.showMessageDialog(null, "Poprawna odpowiedz");

               poprawneOdpowiedzi++;
            } else {
                JOptionPane.showMessageDialog(null, "NiePoprawna odpowiedz");
                      zleOdpowiedzi++;
         
            }
            try {
                ustawPytanie();
            } catch (IOException ex) {
                Logger.getLogger(Okno_Pytania.class.getName()).log(Level.SEVERE, null, ex);

            }
            zmianaPytania();

        }
        if (src == odpowiedz_4Button) {
            if (odpowiedz_4Button.getText().equals(pytanie.odp1)) {
                JOptionPane.showMessageDialog(null, "Poprawna odpowiedz");

                   poprawneOdpowiedzi++;

            } else {
                JOptionPane.showMessageDialog(null, "Niepoprawna odpowiedz");
                      zleOdpowiedzi++;
          
            }
            try {
                ustawPytanie();
            } catch (IOException ex) {
                Logger.getLogger(Okno_Pytania.class.getName()).log(Level.SEVERE, null, ex);

            }
            zmianaPytania();

        }
           
           
    }

    private void zmianaPytania() {

        pytanieArea.setText(pytanie.tresc);
        Collections.shuffle(listaPrzyciskow);
        listaPrzyciskow.get(0).setText(pytanie.odp1);
        listaPrzyciskow.get(1).setText(pytanie.odp2);
        listaPrzyciskow.get(2).setText(pytanie.odp3);
        listaPrzyciskow.get(3).setText(pytanie.odp4);

    }
}
