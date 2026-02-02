package org.example.blinov.glava4.flowers.dto.flowers;

import java.math.BigDecimal;

public class Rose extends Flower {
    private int numberOfThorns;

    public Rose(double stemLength, BigDecimal price, int fresh, FlowerColor flowerColor, int numberOfThorns) {
        super("Роза", stemLength, price, fresh, flowerColor);
        this.numberOfThorns = numberOfThorns;
    }
}
