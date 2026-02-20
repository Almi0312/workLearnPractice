package org.example.blinov.glava5;

public abstract class Service {
    private String name;
    private String cost;
    private String description;

    public Service(String description, String cost, String name) {
        this.description = description;
        this.cost = cost;
        this.name = name;
    }
}
