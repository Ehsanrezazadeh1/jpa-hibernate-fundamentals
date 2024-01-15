package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import org.example.entities.keys.ProductKey;

@Entity
@IdClass(ProductKey.class) // if we want to mark two or more fields to be ou @Id or PK, we take the fields to a class that be Serializable and annotate the entity class
// with @IdClass and also annotate the fields that we want to be our @Id (PK)
public class Products {
    @Id
    private String code;
    @Id
    private long number;
    private String color;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
