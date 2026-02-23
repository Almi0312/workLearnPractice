package org.example.blinov.glava6.candies.entity;

public class Lollipop extends Candy {

    private String flavor; // вкус

    @Override
    public String specialUniqInfo() {
        return flavor;
    }
}
