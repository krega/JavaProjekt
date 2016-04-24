/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author Kamil
 */
public class ManageUser {

 private static SessionFactory factory; 
 
public ManageUser()
{
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
 public Long addUser(Credentials CR){
     
      Session session = factory.openSession();
      Transaction tx = null;
      Long employeeID = null;
      try{
         tx = session.beginTransaction();
         User user = new User(CR);
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
 
 public Credentials addCredential(String login, String haslo) {
      Session session = factory.openSession();
      Transaction tx = null;
      Integer credentialID = null;
      Credentials credential = null;
      try{
         tx = session.beginTransaction();
         credential = new Credentials(login, haslo);
         credentialID = (Integer) session.save(credential); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return credential;
   }
  public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM Employee").list(); 
         for (Iterator iterator = 
                           employees.iterator(); iterator.hasNext();){
           User user = (User) iterator.next(); 
            System.out.print("First Name: " + user.getCredentials().getLogin()); 
            System.out.print("  Last Name: " + user.getCredentials().getHaslo()); 
          
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
 
}
