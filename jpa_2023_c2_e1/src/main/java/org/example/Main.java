package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entities.Employee;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap<>()); //this is for not XML WAY

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit"); // this is for XML way
        EntityManager em = emf.createEntityManager();  // represents the context

    try {
        em.getTransaction().begin();  //  <<<<START OF TRANSACTION>>>>

        Employee e = new Employee();
        e.setId(1);
        e.setName("Ehsan");
        e.setAddress("Sao Paolo, Brazil");

        em.persist(e);

        Employee e1 = em.find(Employee.class, 1);
        System.out.println(e1);

       em.remove(e1);

        // ways to work with CONTEXT:
        // persist()
        // find()
        //merge()
        //detach()
        //removal()
        //getReference()


        em.getTransaction().commit();  // with commit, we mirror the context to database!   <<<<END OF TRANSACTION>>>>
    }finally {
        em.close();
    }

    }
}