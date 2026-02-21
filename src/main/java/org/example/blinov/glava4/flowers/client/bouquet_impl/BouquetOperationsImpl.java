package org.example.blinov.glava4.flowers.client.bouquet_impl;

import lombok.Getter;
import org.example.blinov.glava4.flowers.client.AccessoryOperations;
import org.example.blinov.glava4.flowers.client.BouquetOperations;
import org.example.blinov.glava4.flowers.client.FlowerOperations;
import org.example.blinov.glava4.flowers.client.flowers_impl.FlowerSearch;
import org.example.blinov.glava4.flowers.client.flowers_impl.FlowerSort;
import org.example.blinov.glava4.flowers.dto.bouquets.Bouquet;

import java.util.concurrent.atomic.AtomicReference;

public class BouquetOperationsImpl implements BouquetOperations {

    @Getter
    private final Bouquet bouquet;
    private final AtomicReference<FlowerOperations> flowerOperations;
    private final AtomicReference<AccessoryOperations> accessoryOperations;

    public BouquetOperationsImpl(Bouquet bouquet) {
        this.bouquet = bouquet;
        this.flowerOperations = new AtomicReference<>();
        this.accessoryOperations = new AtomicReference<>();
    }

    @Override
    public FlowerSort toFlowerSort() {
        return getFlowerOperations().toSort();
    }

    @Override
    public FlowerSearch toFlowerSearch() {
        return getFlowerOperations().toSearch();
    }

    public FlowerOperations getFlowerOperations() {
        return this.flowerOperations.updateAndGet(cur -> cur != null ? cur : FlowerOperations.of(bouquet.getFlowers()));
    }

    public AccessoryOperations getAccessoryOperations() {
        return this.accessoryOperations.updateAndGet(cur -> cur != null ? cur : AccessoryOperations.of(bouquet.getAccessories()));
    }

}
