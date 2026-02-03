package org.example.blinov.glava4.flowers.dto.bouquets;

import lombok.Getter;
import org.example.blinov.glava4.flowers.dto.accessories.Accessory;
import org.example.blinov.glava4.flowers.dto.flowers.Flower;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Getter
public class Bouquet {
    private final List<Flower> flowers;
    private final List<Accessory> accessories;

    public Bouquet(BouquetBuilder builder) {
        this.flowers = builder.flowers;
        this.accessories = builder.accessories;
    }

    public BigDecimal getTotalCost() {
        return Stream.concat(
                flowers.stream().map(Flower::getPrice),
                accessories.stream().map(Accessory::getPrice)
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static BouquetBuilder builder() {
        return new BouquetBuilder();
    }

    public static BouquetBuilder builder(List<Flower> flowers,
                                         List<Accessory> accessories) {
        return new BouquetBuilder(flowers, accessories);
    }

    public static class BouquetBuilder {
        private final List<Flower> flowers;
        private final List<Accessory> accessories;
        private BigDecimal totalCost;

        public BouquetBuilder() {
            this.flowers = new ArrayList<>(100);
            this.accessories = new ArrayList<>(20);
        }

        public BouquetBuilder(List<Flower> flowers,
                              List<Accessory> accessories) {
            this.flowers = flowers;
            this.accessories = accessories;
        }

        public BouquetBuilder addFlower(Flower... flowers) {
            Collections.addAll(this.flowers, flowers);
            return this;
        }

        public BouquetBuilder addAccessory(Accessory... accessories) {
            Collections.addAll(this.accessories, accessories);
            return this;
        }

        public BouquetBuilder removeFlower(Flower... flowers) {
            for (Flower flower : flowers) {
                this.flowers.remove(flower);
            }
            return this;
        }

        public BouquetBuilder removeAccessory(Accessory... accessories) {
            for (Accessory accessory : accessories) {
                this.accessories.remove(accessory);
            }
            return this;
        }

        public Bouquet build() {
            return new Bouquet(this);
        }
    }

}
