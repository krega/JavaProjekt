/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import info.kamil.domain.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kamil
 */
public class Main {

 public Main(){
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = new User();
        user.setLogin("kamilek");
        user.setHaslo("rega");
         User user2 = new User();
        user2.setLogin("tomek");
        user2.setHaslo("rega1111");
        User user3=new User();
        user3.setLogin("przemek");
        user3.setHaslo("rega1111");
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.persist(user2);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
 }
}
