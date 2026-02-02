package org.example.blinov.glava4.flowers.dto.accessories;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public abstract class Accessory implements Comparable<Accessory> {
    private String name;
    private BigDecimal price;
    private String description;

    public Accessory(String name, BigDecimal price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public int compareTo(Accessory o) {
        return price.compareTo(o.getPrice());
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%.2f руб.)", name, description, price);
    }
}
