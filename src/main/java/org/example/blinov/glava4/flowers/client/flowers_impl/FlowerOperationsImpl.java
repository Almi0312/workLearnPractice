package org.example.blinov.glava4.flowers.client.flowers_impl;

import org.example.blinov.glava4.flowers.client.FlowerOperations;
import org.example.blinov.glava4.flowers.dto.flowers.Flower;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class FlowerOperationsImpl implements FlowerOperations {

    private final List<Flower> originalFlowers;

    private final AtomicReference<FlowerSearch> flowerSearch;
    private final AtomicReference<FlowerSort> flowerSort;

    public FlowerOperationsImpl(List<Flower> flowers) {
        this.originalFlowers = List.copyOf(flowers);
        this.flowerSearch = new AtomicReference<>();
        this.flowerSort = new AtomicReference<>();
    }

    @Override
    public FlowerSearch toSearch() {
        return flowerSearch.updateAndGet(cur -> cur != null ? cur : new FlowerSearchImpl(originalFlowers));
    }

    @Override
    public FlowerSort toSort() {
        return flowerSort.updateAndGet(cur -> cur != null ? cur : new FlowerSortImpl(originalFlowers));
    }
}
