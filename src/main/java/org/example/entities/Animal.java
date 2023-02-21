package org.example.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "animal_type")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date birthDate;
    private String color;

    @ManyToOne
    private Petstore petstore;

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPetstore(Petstore petstore) {
        this.petstore = petstore;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                ", color='" + color + '\'' +
                ", petstore=" + petstore +
                '}';
    }
}

