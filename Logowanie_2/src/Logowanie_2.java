
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kamil
 */
public class Logowanie_2 {

    private static SessionFactory factory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
//            factory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
        ManageUser MU = new ManageUser();
        MU.addUser(new Credentials("111","hhhhsasah"));
        MU.addUser(new Credentials("222","hh"));
        
//        MU.addUser(MU.addCredential("aaa", "bbbb"));
//        MU.listEmployees();

        Panel_Logowania Panel = new Panel_Logowania(new FileCredentialHandler());

        // TODO code application logic here
    }

}
