package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    public enum ProdType {
        FOOD, ACCESSORY, CLEANING
    }

    @Id
    private String code;
    private String label;
    private Double price;
    @Enumerated(EnumType.STRING)
    private ProdType type;

    @ManyToMany(mappedBy = "products")
    private List<Petstore> petstores;

    public void setCode(String code) {
        this.code = code;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(ProdType type) {
        this.type = type;
    }
}
