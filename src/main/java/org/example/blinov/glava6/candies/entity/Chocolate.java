package org.example.blinov.glava6.candies.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Chocolate extends Candy {
    private String cocoaPercentage;

    public Chocolate(String name, Brand brand, double weight, List<Ingredient> ingredients) {
        super(name, brand, weight, ingredients);
    }

    @Override
    public String specialUniqInfo() {
        return cocoaPercentage;
    }
}
