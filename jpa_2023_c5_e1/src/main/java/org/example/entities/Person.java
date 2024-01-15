package org.example.entities;

import jakarta.persistence.*;

@Entity

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    // declare one-to-one relationship:
    @OneToOne(cascade = CascadeType.PERSIST) // we can use Cascade to when we want to an entity get method in Context, the other entity get that too!
    // for example with this we can only use em.persist(person) and passport also get persist and no need to use em.persist(passport)
    @JoinColumn(name = "passport")
    private Passport passport;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passport=" + passport +
                '}';
    }
}
