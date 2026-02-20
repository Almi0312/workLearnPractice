package org.example.blinov.glava5;

import org.example.blinov.glava5.entity.DepartmentEntity;
import org.example.blinov.glava5.entity.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Создать класс Shop с внутренним классом, с помощью объектов которого можно хранить информацию
 * об отделах, товарах и услугах<br>
 * {@link Department} - inner-класс
 * {@link Address} - inner-класс
 */
public class ShopDTO {
    private Set<Department> departments;
    private final Address address;

    public ShopDTO(Address address) {
        this.address = address;
    }

    public Service addService(Service service) {
        return service;
    }

    public ShopDTO setDepartments(Set<Department> departments) {
        this.departments = departments;
        return this;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public ShopDTO printAllDepartments() {
        System.out.printf("%s", this.getDepartments());
        return this;
    }

    public class Department {
        private String name;
        private final List<Product> products;
        private final List<Service> services;

        public Department() {
            this.products = new ArrayList<>();
            this.services = new ArrayList<>();
        }

        public ShopDTO addProduct(String departmentName, Product product) {
            for (Department department : departments) {
                if (department.getName().equals(departmentName)) {
                    department.getProducts().add(product);
                }
            }
            return ShopDTO.this;
        }

        public String getName() {
            return this.name;
        }

        public List<Service> getServices() {
            return this.services;
        }

        public List<Product> getProducts() {
            return this.products;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Department that = (Department) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }

        @Override
        public String toString() {
            return "\n" + "Отдел - " + name + ", Продукты внутри: " + products + ", Предоставляемые услуги: " + services;
        }
    }

    public static class Address {
        String city;
        String street;
        Integer house;
        Integer room;
    }
}
