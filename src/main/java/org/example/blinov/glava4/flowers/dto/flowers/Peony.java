package org.example.blinov.glava4.flowers.dto.flowers;

import java.math.BigDecimal;

public class Peony extends Flower {

    public Peony(double stemLength, BigDecimal price, int fresh, FlowerColor flowerColor) {
        super("Пион", stemLength, price, fresh, flowerColor);
    }
}
