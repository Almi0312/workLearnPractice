package org.example.blinov.glava5.data;

import org.example.blinov.glava5.entity.*;
import org.example.blinov.glava5.entity.products.Bread;
import org.example.blinov.glava5.entity.products.Limonad;
import org.example.blinov.glava5.entity.products.Milk;
import org.example.blinov.glava5.entity.service.ForSale;
import org.example.blinov.glava5.entity.service.ServiceEntity;

import java.math.BigDecimal;
import java.util.List;

public class Data {
    public static List<ShopEntity> shops;
    public static List<DepartmentEntity> departments;
    public static List<org.example.blinov.glava5.entity.products.Product> products;
    public static List<ServiceEntity> services;

    public static void init() {
        initShops();

    }

    private static void initShops() {
        shops = List.of(new ShopEntity());
    }

    private static void initDepartment() {
        departments = List.of(
                new DepartmentEntity("Хлебные изделия"),
                new DepartmentEntity("Молочная продукция"),
                new DepartmentEntity("Бакалея"));
    }

    private static void initProduct() {
        products = List.of(
                new Milk("Молоко", BigDecimal.valueOf(34.3)),
                new Limonad("Лимонад", BigDecimal.valueOf(143.3)),
                new Bread("Батон", BigDecimal.valueOf(40.3)));
    }

    private static void initService() {
        services = List.of(
                new ForSale("Продажа товара"));
    }

}
