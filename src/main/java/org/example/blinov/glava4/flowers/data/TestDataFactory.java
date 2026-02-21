package org.example.blinov.glava4.flowers.data;

import org.example.blinov.glava4.flowers.dto.bouquets.Bouquet;
import org.example.blinov.glava4.flowers.dto.accessories.Ribbon;
import org.example.blinov.glava4.flowers.dto.flowers.*;

import java.math.BigDecimal;

public final class TestDataFactory {
    private TestDataFactory() {
    }

    public static Bouquet createSampleBouquet() {
        return Bouquet.builder()
                .addFlower(
                        new Rose(8, BigDecimal.valueOf(180), 4, FlowerColor.PINK, 0),
                        new Rose(13, BigDecimal.valueOf(180), 7, FlowerColor.PINK, 0),
                        new Peony(16, BigDecimal.valueOf(260), 5, FlowerColor.RED),
                        new Peony(19, BigDecimal.valueOf(260), 5, FlowerColor.RED),
                        new Rose(12, BigDecimal.valueOf(180), 1, FlowerColor.PINK, 0),
                        new Rose(5, BigDecimal.valueOf(180), 9, FlowerColor.PINK, 0),
                        new Chamomile(25, BigDecimal.valueOf(140), 7, FlowerColor.PINK),
                        new Chamomile(22, BigDecimal.valueOf(140), 5, FlowerColor.WHITE),
                        new Chamomile(22, BigDecimal.valueOf(140), 7, FlowerColor.YELLOW),
                        new Tulip(14, BigDecimal.valueOf(150), 10, FlowerColor.YELLOW),
                        new Tulip(16, BigDecimal.valueOf(150), 7, FlowerColor.YELLOW))
                .build();
    }

    public static Bouquet createWeddingBouquet() {
        return Bouquet.builder()
                .addFlower(
                        new Rose(10, BigDecimal.valueOf(200), 10, FlowerColor.WHITE, 5),
                        new Peony(15, BigDecimal.valueOf(250), 9, FlowerColor.WHITE),
                        new Rose(10, BigDecimal.valueOf(200), 10, FlowerColor.WHITE, 5))
                .addAccessory(new Ribbon(BigDecimal.valueOf(50), "Белая атласная"))
                .build();
    }
}
