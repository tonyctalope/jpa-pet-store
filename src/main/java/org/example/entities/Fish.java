package org.example.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("FISH")
public class Fish extends Animal {
    public enum LivingEnv {
        FRESH_WATER, SEA_WATER
    }

    @Enumerated(EnumType.STRING)
    private LivingEnv livingEnv;

    public void setLivingEnv(LivingEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
