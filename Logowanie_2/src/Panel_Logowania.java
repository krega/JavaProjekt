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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kamil
 */
public class Panel_Logowania extends JFrame implements ActionListener {

    private JLabel Login;
    private JLabel Haslo;
    private JTextArea LoginTextField;
    private JPasswordField HasloPasswordField;
    private JButton OK;
    private JButton Rejestracja;
    private HashMap mapa;
    Register reg;
    private JFrame panelFrame;
    ICredentialHandler handler;

    public Panel_Logowania() {
        initRegister();
        initPanelFrame();
        initLabelLogin();
        initLabelHaslo();
        InitLoginTextArea(panelFrame);
        initPasswordField();
        initButtonOk();
        initButtonRejestracja();  
        panelFrame.setVisible(true);
        

       
    }

    private void initRegister() {
        reg=new Register("C:\\Users\\Kamil\\Documents\\NetBeansProjects\\Logowanie\\JavaProjekt\\Logowanie_2\\plik.txt");
        try {
            mapa=reg.Odczyt();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Panel_Logowania.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initButtonRejestracja() {
        Rejestracja = new JButton("Rejestracja");
        Rejestracja.setLayout(null);
        Rejestracja.setBounds(20, 200, 120, 40);
        panelFrame.add(Rejestracja);
        Rejestracja.addActionListener(this);
    }

    private void initButtonOk() {
        OK = new JButton("OK");
        OK.setLayout(null);
        OK.setBounds(280, 200, 60, 40);
        OK.addActionListener(this);
        panelFrame.add(OK);
    }

    private void initPasswordField() {
        HasloPasswordField = new JPasswordField();
        HasloPasswordField.setLayout(null);
        HasloPasswordField.setBounds(200, 140, 100, 17);
        panelFrame.add(HasloPasswordField);
    }

    private void initLabelHaslo() {
        Haslo = new JLabel("Haslo");
        Haslo.setLayout(null);
        Haslo.setBounds(100, 100, 400, 100);
        panelFrame.add(Haslo);
    }

    private void initLabelLogin() {
        Login = new JLabel("Login");
        Login.setLayout(null);
        Login.setBounds(100, 50, 400, 100);
        panelFrame.add(Login);
    }

    private void initPanelFrame() throws HeadlessException {
        panelFrame = new JFrame("Panel Logowania");
        panelFrame.setLayout(null);
        panelFrame.setBounds(400, 400, 400, 400);
         
        
        
    }
    

    private void InitLoginTextArea(JFrame Panel) {
        LoginTextField = new JTextArea("Login");
        LoginTextField.setLayout(null);
        LoginTextField.setBounds(200, 92, 100, 17);
        Panel.add(LoginTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        Boolean sprawdz = false;

        if (src == OK) {

            sprawdzLogin(sprawdz);
        } else if (src == Rejestracja) {
            this.setVisible(false);

            Panel_Rejestracji panel = new Panel_Rejestracji(mapa);

        }
    }

    private void sprawdzLogin(Boolean sprawdz) throws HeadlessException {
        try {
            HashMap nowa = new HashMap();
            String passString = new String(HasloPasswordField.getPassword());
            
//                ICredentialHandler credHnd = new fileCredentialHandler(filename);
//                ICredentialHandler credHnd = new dbCredentialHandler(url);
Register reg = new Register("C:\\Users\\Kamil\\Documents\\NetBeansProjects\\Logowanie\\JavaProjekt\\Logowanie_2\\plik.txt");

mapa=  handler.Odczyt();
Iterator<Map.Entry<String, String>> entries = mapa.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry<String, String> entry = entries.next();
    String key = entry.getKey();
    String value = entry.getValue();
   
    if (key.equals(LoginTextField.getText())&& value.equals(passString)) {
        
        sprawdz = true;
    }
    
    
}
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Panel_Logowania.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (IOException ex) {
            Logger.getLogger(Panel_Logowania.class.getName()).log(Level.SEVERE, null, ex);
        }
                if (sprawdz == true) {
            
            JOptionPane.showMessageDialog(null, "Witaj " + LoginTextField.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Blad Logowania");            
        }
    }

}
