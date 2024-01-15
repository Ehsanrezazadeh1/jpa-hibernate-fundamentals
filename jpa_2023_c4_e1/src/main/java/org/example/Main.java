package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entities.Student;
import org.example.entities.keys.StudentKey;
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

//        Employee e1 = new Employee();
//        e1.setName("Ehsan");
//        e1.setAddress("Shademan st");
//
//        em.persist(e1);

//        Products p1 = new Products();
//        p1.setCode("ABC");
//        p1.setColor("Red");
//        p1.setNumber(123);
//
//        em.persist(p1);

        StudentKey id = new StudentKey();
        id.setCode("ABCsD");
        id.setNumber(123425);
//
//        Student s1 = new Student();
//        s1.setName("Ehsan");
//        s1.setId(id);
//
//        em.persist(s1);

        Student s = em.find(Student.class, id);
        System.out.println(s);


        em.getTransaction().commit();  // with commit, we mirror the context to database!   <<<<END OF TRANSACTION>>>>
    }finally {
        em.close();
    }

    }
}