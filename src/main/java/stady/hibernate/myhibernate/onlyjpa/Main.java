package stady.hibernate.myhibernate.onlyjpa;

import stady.hibernate.myhibernate.first.UserMassage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("helloworld");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        UserMassage userMassage = new UserMassage();
        userMassage.setMessage("Hayyayaya +"+ new Date());
        em.persist(userMassage);
        et.commit();

        et.begin();
        List mes = em.createQuery("select m from UserMassage m").getResultList();
        for (Object obj : mes){
            UserMassage userMassage1 = (UserMassage)obj;
            System.out.println(userMassage1.getMessage());
        }
        et.commit();
        em.close();
        entityManagerFactory.close();





    }
}
