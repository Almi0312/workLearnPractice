package org.example.blinov.glava6.candies.entity;

public class Iris extends Candy {

    private String chewiness; // Мягкость

    @Override
    public String specialUniqInfo() {
        return chewiness;
    }
}
