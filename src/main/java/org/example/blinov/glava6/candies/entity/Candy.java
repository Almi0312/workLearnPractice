package org.example.blinov.glava6.candies.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.blinov.glava6.candies.anno.NotNull;

import java.util.List;

import static org.example.blinov.glava6.candies.utils.NotNullAnnoUtils.checkWhatFieldNonNull;

@Getter
@Setter
public abstract class Candy {
    @NotNull
    protected String name;

    @NotNull
    protected Brand brand;

    @NotNull
    protected double weight;

    @NotNull
    protected List<Ingredient> ingredients;

    protected int quantityStock;
    protected boolean isProducible;

    public Candy(String name, Brand brand, double weight, List<Ingredient> ingredients) {
        this.name = name;
        this.brand = brand;
        this.weight = weight;
        this.ingredients = ingredients;
        checkWhatFieldNonNull(this);
    }

    public abstract String specialUniqInfo();

    public enum CandyField {
        name,
        brand,
        weight,
        ingredients,
        quantityStock,
        isProducible,
    }

}
