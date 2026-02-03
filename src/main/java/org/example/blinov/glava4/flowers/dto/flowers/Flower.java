package org.example.blinov.glava4.flowers.dto.flowers;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public abstract class Flower implements Comparable<Flower> {

    {
        uuid = UUID.randomUUID();
    }

    protected final UUID uuid;
    protected String name;
    protected double stemLength;
    protected BigDecimal price;
    protected int freshLvl;
    protected FlowerColor flowerColor;

    public Flower() {
    }

    public Flower(String name, double stemLength, BigDecimal price, int fresh, FlowerColor flowerColor) {
        this.name = name;
        this.stemLength = stemLength;
        this.price = price;
        this.freshLvl = fresh;
        this.flowerColor = flowerColor;
    }

    public String getDescription() {
        return String.format("%s, стебель: %.1f см", name, stemLength);
    }

    public int getFreshnessLevel() {
        return this.freshLvl;
    }

    public String getFlowerColor() {
        return flowerColor.color;
    }

    @Override
    public int compareTo(Flower o) {
        return this.getPrice().compareTo(o.getPrice());
    }

    @Override
    public String toString() {
        return String.format("\n%s с цветом %s (%.1f см, свежесть: %d/10, цена: %.2f руб.)",
                name, getFlowerColor(), stemLength, freshLvl, price);
    }
}
