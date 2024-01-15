package org.example.entities;


import jakarta.persistence.*;
import org.example.entities.generators.UUIDGenerator;
import org.hibernate.annotations.GenericGenerator;

@Entity  // if we add name to this, it says the name of entity in the CONTEXT of Framework, in this case Hibernate!
@Table(name = "employee")  // it says the name of entity in DATABASE!!!!!! the name that use in Query is the name of @table
public class Employee {

    @Id
    @GenericGenerator(name = "UUIDGenerator", type = UUIDGenerator.class) //generate random ID use UUID
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(length = 500)
    private String  id;

    private String name;

    private String address;

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
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
