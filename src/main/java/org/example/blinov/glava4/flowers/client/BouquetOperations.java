package org.example.blinov.glava4.flowers.client;

import org.example.blinov.glava4.flowers.client.bouquet_impl.BouquetOperationsImpl;
import org.example.blinov.glava4.flowers.client.flowers_impl.FlowerSearch;
import org.example.blinov.glava4.flowers.client.flowers_impl.FlowerSort;
import org.example.blinov.glava4.flowers.dto.bouquets.Bouquet;

public interface BouquetOperations {

    static BouquetOperations of(Bouquet bouquet) {
        return new BouquetOperationsImpl(bouquet);
    }

    Bouquet getBouquet();

    FlowerSort toFlowerSort();

    FlowerSearch toFlowerSearch();

}
