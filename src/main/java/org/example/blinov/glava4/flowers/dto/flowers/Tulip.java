package org.example.blinov.glava4.flowers.dto.flowers;

import java.math.BigDecimal;

public class Tulip extends Flower {

    public Tulip(double stemLength, BigDecimal price, int fresh, FlowerColor flowerColor) {
        super("Тюльпан", stemLength, price, fresh, flowerColor);
    }
}
