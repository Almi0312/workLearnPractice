package org.example.blinov.glava6.candies.service;

import org.example.blinov.glava6.candies.anno.FindBy;
import org.example.blinov.glava6.candies.data.Data;
import org.example.blinov.glava6.candies.entity.Brand;
import org.example.blinov.glava6.candies.entity.Candy;
import org.example.blinov.glava6.candies.entity.Chocolate;
import org.example.blinov.glava6.candies.entity.Ingredient;
import org.example.blinov.glava6.candies.interfaces.*;

import java.util.*;

public class CandyManager implements CandyOperations {

    @Override
    public void discontinueCandy(String name, Brand brand) {
        findCandyByNameAndBrend(name, brand).orElseThrow().setProducible(false);
    }

    @Override
    public Chocolate addChocolateCandy(String name,
                                       Brand brand,
                                       double weight,
                                       List<Ingredient> ingredients,
                                       int quantityStock,
                                       String cocoaPercentage) {
        Chocolate chocolate = new Chocolate(name, brand, weight, ingredients);
        chocolate.setQuantityStock(quantityStock);
        chocolate.setProducible(false);
        chocolate.setCocoaPercentage(cocoaPercentage);
        Data.candies.add(chocolate);
        return chocolate;
    }

    @Override
    public Candy editCandy(Candy candy) {
        Candy actCandy = findCandyByNameAndBrend(candy.getName(), candy.getBrand()).orElseThrow();
        actCandy.setName(candy.getName());
        actCandy.setBrand(candy.getBrand());
        actCandy.setIngredients(candy.getIngredients());
        actCandy.setQuantityStock(candy.getQuantityStock());
        actCandy.setProducible(candy.isProducible());
        return actCandy;
    }

    @Override
    public Optional<Candy> findCandyByName(String name) {
        return Optional.empty();
    }

    /**
     * {@link org.example.blinov.glava6.candies.proxy.CandyManageHandler}
     */
    @Override
    public Optional<Candy> findCandyByNameAndBrend(String name, Brand brand) {
        return Optional.empty();
    }

    @Override
    public Candy addIngredient() {
        return null;
    }

    @Override
    public Candy removeIngredient() {
        return null;
    }

    @Override
    public void produceCandy(String name, int quantity) {

    }
}
