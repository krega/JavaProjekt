
import java.awt.Dimension;
import java.io.FileNotFoundException;
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
public class Okno_Pytania {
    private JTextArea pytanieArea;
    private JButton odpowiedz_1Button,odpowiedz_2Button,odpowiedz_3Button,odpowiedz_4Button;
    private JFrame panelFrame;
    private String pytanie,odpowiedz_1,odpowiedz_2,odpowiedz_3,odpowiedz_4;
    private Pytanie pyt;
       IPobierzPytanie pobierz;
       Kategoria kategoria;
    
    
    public Okno_Pytania(Kategoria kat) throws FileNotFoundException{
        kategoria=kat;
        pobierz=new DostanPytanie();
         pyt=new Pytanie(pobierz, kat);
        initJFramePanelFrame();
        initJTextAreaPytanie();
        initJButtonOdpowiedz_1();
        panelFrame.setVisible(true);
       
    }
    private void initJFramePanelFrame(){
        panelFrame=new JFrame("Okno pytania");
        panelFrame.setLayout(null);
        panelFrame.setBounds(1000,1000,1000,1000);
        panelFrame.setSize(new Dimension(500, 600));
        panelFrame.setLocation(100, 100);
        
    }
     private void initJButtonOdpowiedz_1()
     {
    /*     odpowiedz_1=new JButton();
         odpowiedz_1.set*/
     }
    
    private void initJTextAreaPytanie(){
        
        pytanieArea=new JTextArea(pyt.tresc);
        pytanieArea.setLayout(null);
        pytanieArea.setBounds(10,10,900,900);
        panelFrame.add(pytanieArea);
    }
    
    
}
