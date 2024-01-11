package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entities.Employee;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String puName = "pu-name";
        Map<String, String > props = new HashMap<>();
        props.put("hibernate.show_sql", "true"); // show sql queries
        props.put("hibernate.hbm2ddl.auto", "update"); // in real world apps never do this, when we change model it goes to db
        // we have create ,none and update

        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props); //this is for not XML WAY
        EntityManager em = emf.createEntityManager();  // represents the context

    try {
        em.getTransaction().begin();  //  <<<<START OF TRANSACTION>>>>


//        find vs getReference
//        var e1 = em.find(Employee.class, 1);
//        System.out.println(e1);

        var e2 = new Employee();
        e2.setName("Milad");
        e2.setAddress("Iran");
        em.persist(e2);

        //var e2 = em.getReference(Employee.class,1);  // in getReference we add data from db to Context and when we need it, it can be used
        //maybe we do not want to use that instance in context now, but maybe we use it tomorrow, so we use getReference here
        // we can say that when we use getReference, we do not query anything yet until we change that entity, for example when we change the address of that entity it will have
        // query to DB, but without change anything it doesn't have any query, it is just ready to take query!!  (LAZY)


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