package org.example.blinov.glava5.entity.products;

import java.math.BigDecimal;

public abstract class Product {
        protected String name;
        protected BigDecimal cost;

        public Product(String name, BigDecimal cost) {
                this.name = name;
                this.cost = cost;
        }
}
