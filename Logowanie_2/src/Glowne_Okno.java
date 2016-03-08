
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class Glowne_Okno extends JFrame implements ActionListener {
    
    private JFrame framePanel;
    private JButton przyciskRozpocznijGre;
    private JButton przyciskStatystyka;
    private JButton przyciskWyjdz;
    private JButton zasadyGry;
    private JButton oAutorze;
    private Wybor_Kategorii wyborKategorii;
    private User user;
    public Glowne_Okno(User us){
        user=us;
        initframePanel();
        initJButtonRozpocznijGre();
        initJButtonStatystyki();
        initJButtonZasadyGry();
        initJButtonWyjdz();
        initJButtonOAutorze();
        
        
        framePanel.setVisible(true);
    }
    private void initJButtonOAutorze()
    {
        oAutorze=new JButton("O Autorze");
        oAutorze.addActionListener(this);
        oAutorze.setLayout(null);
        oAutorze.setBounds(100,400,300,50);
        framePanel.add(oAutorze);
        
    }
    private void initJButtonZasadyGry()
    {
        zasadyGry=new JButton("Zasady Gry");
        zasadyGry.addActionListener(this);
        zasadyGry.setLayout(null);
        zasadyGry.setBounds(100,330,300,50);
        framePanel.add(zasadyGry);
    }
    private void initJButtonWyjdz()
    {
        przyciskWyjdz=new JButton("Wyjdz z gry");
        przyciskWyjdz.addActionListener(this);
        przyciskWyjdz.setLayout(null);
        przyciskWyjdz.setBounds(100,500,300,50);
        framePanel.add(przyciskWyjdz);
    }
    private void initJButtonStatystyki()
    {
        przyciskStatystyka=new JButton("Zobacz Statysyki");
        przyciskStatystyka.addActionListener(this);
        przyciskStatystyka.setLayout(null);
        przyciskStatystyka.setBounds(100,150,300,50);
        framePanel.add( przyciskStatystyka); 
        
    }
    private void initJButtonRozpocznijGre()
    {
        przyciskRozpocznijGre=new JButton("Rozpocznij Gre");
        przyciskRozpocznijGre.addActionListener(this);
        przyciskRozpocznijGre.setLayout(null);
        przyciskRozpocznijGre.setBounds(100, 80, 300, 50);
        framePanel.add(przyciskRozpocznijGre);
        
        
    }
    private void initframePanel(){
        framePanel=new JFrame("Okno Gry");
        framePanel.setLayout(null);
        framePanel.setBounds(600,600,600,600);
        framePanel.setSize(new Dimension(500, 600));
        framePanel.setLocation(100, 100);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src==przyciskWyjdz){
             System.exit(0);
          }
        if(src==przyciskRozpocznijGre){
            wyborKategorii=new Wybor_Kategorii(); 
            
        }
        
        
        
   
        
    }
}
