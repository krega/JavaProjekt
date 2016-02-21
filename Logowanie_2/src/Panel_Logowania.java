/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kamil
 */
public class Panel_Logowania extends JFrame implements ActionListener {

   
    private JLabel Login;
    private JLabel Haslo;
    private JTextArea Login_1 ;
    private JPasswordField Haslo_1;
    private JButton OK ;
   private  JButton Rejestracja;

    public Panel_Logowania() {
        

        JFrame Panel = new JFrame("Panel Logowania");
        Panel.setLayout(null);
        Panel.setBounds(400, 400, 400, 400);
        Login = new JLabel("Login");
        Login.setLayout(null);
        Login.setBounds(100, 50, 400, 100);
        Panel.add(Login);
        Haslo = new JLabel("Haslo");
        Haslo.setLayout(null);
        Haslo.setBounds(100, 100, 400, 100);
        Panel.add(Haslo);

        Login_1 = new JTextArea("Login");
        Login_1.setLayout(null);
        Login_1.setBounds(200, 92, 100, 17);
        Panel.add(Login_1);
        Haslo_1 = new JPasswordField();
        Haslo_1.setLayout(null);
        Haslo_1.setBounds(200, 140, 100, 17);
        Panel.add(Haslo_1);

        OK = new JButton("OK");
        OK.setLayout(null);
        OK.setBounds(280, 200, 60, 40);
        OK.addActionListener (this);
        Panel.add(OK);

        Rejestracja = new JButton("Rejestracja");
        Rejestracja.setLayout(null);
        Rejestracja.setBounds(20, 200, 120, 40);
        Panel.add(Rejestracja);
        Rejestracja.addActionListener (this);

        Panel.setSize(new Dimension(400, 300));
        Panel.setLocation(50, 300);
        Panel.setVisible(true);
    }
     @Override
     public void actionPerformed(ActionEvent e) {
           Object src = e.getSource();
            if (src == OK) {

        char[] pass = Haslo_1.getPassword();
        String passString = new String(pass);
         OdczytZPliku odczyt=new OdczytZPliku();
         String LiH=new String(odczyt.Odczyt());
         LiH=LiH.trim();
         String LP=new String(Login_1.getText()+passString);
         
         
       if(LiH.equals(LP)){
         JOptionPane.showMessageDialog(null, "Witaj "+Login.getText());
       }
       else{
            JOptionPane.showMessageDialog(null, "Blad Logowania");
            
           
       }
            }
           else if (src == Rejestracja){
               this.setVisible(false);
               
                Panel_Rejestracji panel=new Panel_Rejestracji();
                
            }
         
     }
}
     
    
    
    


