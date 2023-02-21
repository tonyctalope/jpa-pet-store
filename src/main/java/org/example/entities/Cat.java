package org.example.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAT")
public class Cat extends Animal {
    private String chipId;

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
