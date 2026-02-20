package org.example.blinov.glava5.entity;


import java.util.List;

public class ShopEntity {
    private String name;
    private List<DepartmentEntity> departments;
    private AddressEntity address;

    public ShopEntity() {
    }

    public String getName() {
        return name;
    }

    public ShopEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<DepartmentEntity> getDepartments() {
        return departments;
    }

    public ShopEntity setDepartments(List<DepartmentEntity> departments) {
        this.departments = departments;
        return this;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public ShopEntity setAddress(AddressEntity address) {
        this.address = address;
        return this;
    }
}
