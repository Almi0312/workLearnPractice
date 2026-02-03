package org.example.blinov.glava4.flowers.dto.flowers;

import java.math.BigDecimal;

public class Chamomile extends Flower {

    public Chamomile(double stemLength, BigDecimal price, int fresh, FlowerColor flowerColor) {
        super("Ромашка", stemLength, price, fresh, flowerColor);
    }
}
