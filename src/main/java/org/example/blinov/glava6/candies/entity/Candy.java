package org.example.blinov.glava6.candies.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class Candy {
    protected String name;
    protected Brand brand;
    protected double weight;
    protected List<Ingredient> ingredients;
    protected int quantityStock;
    protected boolean isProducible;

    public abstract String specialUniqInfo();

}
