
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
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

    public Okno_Pytania(IPobierzPytanie pytanie, Kategoria kat) throws FileNotFoundException {
        kategoria = kat;
        listaPytan = pytanie.PobierzPytanie(kategoria);
        losowanie = new Losowanie(listaPytan.size());
        pytania();

        initJFramePanelFrame();
        initJTextAreaPytanie();
        initButtonsOdpowiedzi();
        panelFrame.setVisible(true);

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

    //zmienic nazwe, na jakas znaczaca
    public Pytanie pytania() {
        int a = losowanie.get();
        if (a == -1){
            System.out.println("Zle losowanie");
            return null;
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
        pytania();
        if (src == odpowiedz_1Button) {
            pytanieArea.setText(pytanie.tresc);
            odpowiedz_1Button.setText(pytanie.odp1);
            odpowiedz_2Button.setText(pytanie.odp2);
            odpowiedz_3Button.setText(pytanie.odp3);
            odpowiedz_4Button.setText(pytanie.odp4);
        }
        if (src == odpowiedz_2Button) {
            pytanieArea.setText(pytanie.tresc);
            odpowiedz_1Button.setText(pytanie.odp1);
            odpowiedz_2Button.setText(pytanie.odp2);
            odpowiedz_3Button.setText(pytanie.odp3);
            odpowiedz_4Button.setText(pytanie.odp4);
        }
        if (src == odpowiedz_3Button) {
            pytanieArea.setText(pytanie.tresc);
            odpowiedz_1Button.setText(pytanie.odp1);
            odpowiedz_2Button.setText(pytanie.odp2);
            odpowiedz_3Button.setText(pytanie.odp3);
            odpowiedz_4Button.setText(pytanie.odp4);
        }
        if (src == odpowiedz_4Button) {
            pytanieArea.setText(pytanie.tresc);
            odpowiedz_1Button.setText(pytanie.odp1);
            odpowiedz_2Button.setText(pytanie.odp2);
            odpowiedz_3Button.setText(pytanie.odp3);
            odpowiedz_4Button.setText(pytanie.odp4);
        }
    }
}
