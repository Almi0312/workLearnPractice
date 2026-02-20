package org.example.blinov.glava5.entity.service;

public abstract class ServiceEntity {
    private String name;
    private String cost;
    private String description;

    public ServiceEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ServiceEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCost() {
        return cost;
    }

    public ServiceEntity setCost(String cost) {
        this.cost = cost;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ServiceEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
