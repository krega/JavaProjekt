
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class DataBaseCredentialHandler implements ICredentialHandler {
    private static SessionFactory factory; 
    public DataBaseCredentialHandler(){
       
        try{
      factory = new AnnotationConfiguration().configure().
              addAnnotatedClass(User.class).
              addAnnotatedClass(Liczniki.class).
              buildSessionFactory();
                 
                   
     }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);

         throw new ExceptionInInitializerError(ex); 
      }
    }
    
    
    
    @Override
    public HashMap Odczyt() 
    {
      HashMap<String,User> passmap = new HashMap<String,User>();
     Session session = factory.openSession();
      Transaction tx = null;   
      try{
         tx = session.beginTransaction();
         List<User> list= session.createQuery("FROM User").list(); 
       
            for (User i : list) passmap.put(i.getCredentials().getLogin(),i);
          
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return passmap;
    }
    

    

    @Override
    public Long zapisNowegoUzytkownika(Credentials Cr1) throws IOException {
         Session session = factory.openSession();
      Transaction tx = null;
      Long employeeID = null;
      try{
         tx = session.beginTransaction();
         User user = new User(Cr1);
         employeeID = (Long) session.save(user); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
       return employeeID;
   }
   
    

    
   @Override
    public void zapiszWynik(Long EmployeeID, Map mapa ) {
     Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         User user = session.get(User.class, EmployeeID);
         user.setMapaWynikow(mapa);
         session.update(user);
         tx.commit();
    }
      catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }

    
    }

    
}
