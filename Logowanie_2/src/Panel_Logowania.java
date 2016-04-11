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
    private JFrame panelFrame;
    private ICredentialHandler itsCredentialHandler;
    private Panel_Rejestracji itsPanelRejestracji;
    private Glowne_Okno itsGlowneOkno;

    public Panel_Logowania() {
    }

    public Panel_Logowania(ICredentialHandler handl) {
        itsCredentialHandler = handl;
        initHashMapa();
        initPanelFrame();
        initLabelLogin();
        initLabelHaslo();
        InitLoginTextArea(panelFrame);
        initPasswordField();
        initButtonOk();
        initButtonRejestracja();
        panelFrame.setVisible(true);

    }

    private void initHashMapa() {
        try {
            mapa = itsCredentialHandler.Odczyt();
        } catch (IOException ex) {
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

        if (src == OK) {
            if (sprawdzLogin() == true) {
                //   Credentials Cr=new Credentials(Login.getText(),new String(HasloPasswordField.getPassword()));
                // User user=new User(Cr)
                //  itsGlowneOkno=new Glowne_Okno(new User(Cr));
                panelFrame.dispose();
            }
        } else if (src == Rejestracja) {
            this.setVisible(false);
            itsPanelRejestracji = new Panel_Rejestracji(mapa, this);

        }
    }

    public void NewUser(Credentials Cr) throws IOException {

        itsCredentialHandler.zapisNowegoUzytkownika(Cr);

    }

    private boolean sprawdzLogin() throws HeadlessException {

        if (porownajPassy() == true) {

            JOptionPane.showMessageDialog(null, "Witaj " + LoginTextField.getText());
            return true;
        } else {

            JOptionPane.showMessageDialog(null, "Blad Logowania");
            return false;
        }
    }

    private Boolean porownajPassy() {
        Boolean sprawdz = false;

        String passString = new String(HasloPasswordField.getPassword());
//          ICredentialHandler credHnd = new dbCredentialHandler(url);

        Iterator<Map.Entry<String, User>> entries = mapa.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, User> entry = entries.next();
            Credentials value = entry.getValue().getCredentials();
            if (value.getLogin().equals(LoginTextField.getText()) && value.getHaslo().equals(passString)) {
                sprawdz = true;
                User user = entry.getValue();
                user.setMapaWynikow(entry.getValue().getMapaWynikow());
                itsGlowneOkno = new Glowne_Okno(user, itsCredentialHandler);

            }

        }
        return sprawdz;
    }

}
