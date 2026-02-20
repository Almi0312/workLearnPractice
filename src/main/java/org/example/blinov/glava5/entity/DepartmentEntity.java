package org.example.blinov.glava5.entity;

import org.example.blinov.glava5.Service;
import org.example.blinov.glava5.entity.products.Product;

import java.util.List;

public class DepartmentEntity {
    String name;
    List<Product> products;
    List<Service> services;

    public DepartmentEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public DepartmentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public DepartmentEntity setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public List<Service> getServices() {
        return services;
    }

    public DepartmentEntity setServices(List<Service> services) {
        this.services = services;
        return this;
    }
}
