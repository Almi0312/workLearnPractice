package org.example.blinov.glava6.candies.entity;

import java.util.List;

public class Lollipop extends Candy {

    private String flavor; // вкус

    public Lollipop(String name, Brand brand, double weight, List<Ingredient> ingredients) {
        super(name, brand, weight, ingredients);
    }

    @Override
    public String specialUniqInfo() {
        return flavor;
    }
}
