package org.example.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Petstore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String managerName;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "petstore")
    private List<Animal> animals;

    @ManyToMany
    private List<Product> products;

    public void setName(String name) {
        this.name = name;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
