package org.example.entities;


import jakarta.persistence.*;

@Entity  // if we add name to this, it says the name of entity in the CONTEXT of Framework, in this case Hibernate!
@Table(name = "employee")  // it says the name of entity in DATABASE!!!!!! the name that use in Query is the name of @table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  // when we set to IDENTITY, our DBMS is responsible to set Id to us and no need to set by us!!
    private int id;

    private String name;

    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
