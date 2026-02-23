package org.example.blinov.glava6.candies.entity;

public class Chocolate extends Candy {
    private String cocoaPercentage;

    @Override
    public String specialUniqInfo() {
        return cocoaPercentage;
    }
}
