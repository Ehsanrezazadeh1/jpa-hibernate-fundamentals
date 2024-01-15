package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.example.entities.Passport;
import org.example.entities.Person;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String puName = "pu-name";
        Map<String, String > props = new HashMap<>();
        props.put("hibernate.show_sql", "true"); // show sql queries
        props.put("hibernate.hbm2ddl.auto", "create");

        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props); //this is for not XML WAY
        EntityManager em = emf.createEntityManager();  // represents the context

    try {
        em.getTransaction().begin();  //  <<<<START OF TRANSACTION>>>>

        Person person = new Person();
        person.setName("Ehsan");

        Passport passport = new Passport();
        passport.setNumber("ABC33ZGGA1");


        person.setPassport(passport);
        passport.setPerson(person);

        //em.persist(passport);  we cascade persist in Person.java
        em.persist(person);

//        TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE p.passport.number = :number", Person.class);
//        q.setParameter("number", "ABC33ZGGA1");
//        System.out.println(q.getResultList());


        em.getTransaction().commit();  // with commit, we mirror the context to database!   <<<<END OF TRANSACTION>>>>
    }finally {
        em.close();
    }

    }
}