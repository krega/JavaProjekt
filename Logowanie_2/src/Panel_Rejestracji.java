
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kamil
 */
public class Panel_Rejestracji extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new Panel_Rejestracji();
            
    }
  private  JLabel Login = new JLabel("Login");
  private  JLabel Haslo = new JLabel("Haslo");
   private  JTextArea Login_1 = new JTextArea("Login");
    private JPasswordField Haslo_1 = new JPasswordField();
   private  JButton OK = new JButton("OK");
  
 private  char[] pass = Haslo_1.getPassword();
   String passString = new String(pass);
    
 
  
  
   
     
     
     
     
     
     

    public Panel_Rejestracji() {
        OK.addActionListener(this);
        JFrame Panel = new JFrame("Panel Logowania");
        Panel.setLayout(null);
        Panel.setBounds(400, 400, 400, 400);
        //contentPane.add(new JLabel("Haslo"));

        Login.setLayout(null);
        Login.setBounds(100, 50, 400, 100);
        Panel.add(Login);

        Haslo.setLayout(null);
        Haslo.setBounds(100, 100, 400, 100);
        Panel.add(Haslo);

        Login_1.setLayout(null);
        Login_1.setBounds(200, 92, 100, 17);
        Panel.add(Login_1);

        Haslo_1.setLayout(null);
        Haslo_1.setBounds(200, 140, 100, 17);
        Panel.add(Haslo_1);

        OK.setLayout(null);
        OK.setBounds(280, 200, 60, 40);
        Panel.add(OK);

        Panel.setSize(new Dimension(400, 300));
        Panel.setLocation(50, 300);
        Panel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Credentials Cr = new Credentials(Login_1.getText(),passString );

        User nowy = new User(Cr);
        Register reg = new Register(Cr);
        reg.saveNewUser(Cr);
         System.out.print("aas"+passString);
      

    }
    
}
