
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private JLabel Login;
    private JLabel Haslo;
    private JTextArea Login_1;
    private JPasswordField Haslo_1;
    private JButton OK;
    private char[] pass;
    private JFrame PanelFrame;
    private HashMap mapaLoginow;
    private Panel_Logowania panelLogowania;

    public Panel_Rejestracji(HashMap passmap, Panel_Logowania Panel) {
        panelLogowania = Panel;
        mapaLoginow = passmap;
        initPanelFrame();
        initLabelLogin();
        initLabelHaslo();
        initTextArea();
        initPasswordField();
        initButtonOk();
        PanelFrame.setVisible(true);

    }

    private void initLabelLogin() {
        Login = new JLabel("Login");
        Login.setLayout(null);
        Login.setBounds(100, 50, 400, 100);
        PanelFrame.add(Login);
    }

    private void initPanelFrame() throws HeadlessException {
        PanelFrame = new JFrame("Panel Rejestracji");
        PanelFrame.setLayout(null);
        PanelFrame.setBounds(400, 400, 400, 400);
        PanelFrame.setSize(new Dimension(400, 300));
        PanelFrame.setLocation(50, 300);
    }

    private Boolean saveNewUser(Credentials Cr) {

        if (!mapaLoginow.containsKey(Cr.getLogin())) {

            mapaLoginow.put(Cr.getLogin(), Cr.getHaslo());
         //   new Main(Cr);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Podany login jest zajety");
            return false;
        }

    }

    private void initButtonOk() {
        OK = new JButton("OK");
        OK.addActionListener(this);
        OK.setLayout(null);
        OK.setBounds(280, 200, 60, 40);
        PanelFrame.add(OK);
    }

    private void initPasswordField() {
        Haslo_1 = new JPasswordField();
        Haslo_1.setLayout(null);
        Haslo_1.setBounds(200, 140, 100, 17);
        PanelFrame.add(Haslo_1);
    }

    private void initTextArea() {
        Login_1 = new JTextArea("Login");
        Login_1.setLayout(null);
        Login_1.setBounds(200, 92, 100, 17);
        PanelFrame.add(Login_1);
    }

    private void initLabelHaslo() {
        Haslo = new JLabel("Haslo");
        Haslo.setLayout(null);
        Haslo.setBounds(100, 100, 400, 100);
        PanelFrame.add(Haslo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String passString = new String(Haslo_1.getPassword());
        Credentials Cr = new Credentials(Login_1.getText(), passString);
        User nowy = new User(Cr);
        try {
            if (saveNewUser(Cr) == true) {
                panelLogowania.NewUser(Cr);
                JOptionPane.showMessageDialog(null, "Rejestracja przebiegla pomyslnie");
                PanelFrame.dispose();
            }
        } catch (IOException ex) {
            Logger.getLogger(Panel_Rejestracji.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
