/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Kamil
 */
public class Panel_Logowania extends JFrame {

    public static void main(String[] args) {
        new Panel_Logowania();
    }

    public Panel_Logowania() {

        JFrame Panel = new JFrame("Panel Logowania");
        Panel.setLayout(null);
        Panel.setBounds(400, 400, 400, 400);
        //JPanel contentPane = (JPanel) Panel.getContentPane();

        //contentPane.add(new JLabel("Haslo"));
        JLabel Login = new JLabel("Login");
        Login.setLayout(null);
        Login.setBounds(100, 50, 400, 100);
        Panel.add(Login);
        JLabel Haslo = new JLabel("Haslo");
        Haslo.setLayout(null);
        Haslo.setBounds(100, 100, 400, 100);
        Panel.add(Haslo);

        JTextArea Login_1 = new JTextArea("Login");
        Login_1.setLayout(null);
        Login_1.setBounds(200, 92, 100, 17);
        Panel.add(Login_1);
        JPasswordField Haslo_1 = new JPasswordField();
        Haslo_1.setLayout(null);
        Haslo_1.setBounds(200, 140, 100, 17);
        Panel.add(Haslo_1);

        JButton OK = new JButton("OK");
        OK.setLayout(null);
        OK.setBounds(280, 200, 60, 40);
        Panel.add(OK);

        JButton Rejestracja = new JButton("Rejestracja");
        Rejestracja.setLayout(null);
        Rejestracja.setBounds(20, 200, 120, 40);
        Panel.add(Rejestracja);

        Panel.setSize(new Dimension(400, 300));
        Panel.setLocation(50, 300);
        Panel.setVisible(true);
    }

}
