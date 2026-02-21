package org.example.blinov.glava4.flowers;

import org.example.blinov.glava4.flowers.client.BouquetOperations;
import org.example.blinov.glava4.flowers.client.FlowerOperations;
import org.example.blinov.glava4.flowers.dto.bouquets.Bouquet;
import org.example.blinov.glava4.flowers.dto.flowers.Flower;

import java.util.List;
import java.util.Optional;

public class Print {

    BouquetOperations bouquetOperations;

    public Print(BouquetOperations bouquetOperations) {
        this.bouquetOperations = bouquetOperations;
    }

    public void printSortByFreshness(Bouquet bouquet) {
        System.out.printf("Сортируем цветы в букете по свежести \n%s\n%s\n",
                bouquet.getFlowers(), bouquetOperations.toFlowerSort().sortedByFreshness());
        indent();
    }

    public void printAllFlowerByStemLengthRange(double min, double max) {
        List<Flower> allFlowers = bouquetOperations.getBouquet().getFlowers();
        List<Flower> flowersFromRange = bouquetOperations.toFlowerSearch().findByStemLengthRange(min, max);
        System.out.printf("По диапазону %.1f-%.1f Из цветов %s\n входят только\n %s", min, max, allFlowers, flowersFromRange);
        indent();
    }

    public void printCostBouquet() {
        System.out.printf("Стоимость букета - %s", bouquetOperations.getBouquet().getTotalCost());
        indent();
    }


    public void printFlowerByStemLength(double stemLength) {
        Optional<Flower> flower = bouquetOperations.toFlowerSearch().findByExactStemLength(stemLength);
        flower.ifPresentOrElse(
                x -> System.out.printf("размеру %.1f соответствует %s", stemLength, flower.get()),
                () -> System.out.printf("нет цветка, который соответствует размеру %.1f", stemLength));
        indent();
    }

    private void indent() {
        System.out.println("\n*********************************************************");
    }
}
