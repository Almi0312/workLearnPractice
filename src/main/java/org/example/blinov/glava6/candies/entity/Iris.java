package org.example.blinov.glava6.candies.entity;

import java.util.List;

public class Iris extends Candy {

    private String chewiness; // Мягкость

    public Iris(String name, Brand brand, double weight, List<Ingredient> ingredients) {
        super(name, brand, weight, ingredients);
    }

    @Override
    public String specialUniqInfo() {
        return chewiness;
    }
}
