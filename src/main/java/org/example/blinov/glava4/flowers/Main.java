package org.example.blinov.glava4.flowers;

import org.example.blinov.glava4.flowers.client.BouquetOperations;
import org.example.blinov.glava4.flowers.dto.accessories.Ribbon;
import org.example.blinov.glava4.flowers.dto.bouquets.Bouquet;
import org.example.blinov.glava4.flowers.dto.flowers.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        BouquetOperations bouquetOperations = BouquetOperations.of(Bouquet.builder()
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
                .addAccessory(new Ribbon(BigDecimal.valueOf(20), "Шикарная лента"))
                .build());
        Print print = new Print(bouquetOperations);
        print.printCostBouquet();
        print.printSortByFreshness(bouquetOperations.getBouquet());
        print.printAllFlowerByStemLengthRange(9.2d, 14d);
        print.printAllFlowerByStemLengthRange(100d, 111d);
        print.printFlowerByStemLength(16);
        print.printFlowerByStemLength(0);
    }
}
