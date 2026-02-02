package org.example.blinov.glava4.flowers.client.flowers_impl;

import org.example.blinov.glava4.flowers.dto.flowers.Flower;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FlowerSortImpl implements FlowerSort {

    private final List<Flower> originalFlowers;

    public FlowerSortImpl(List<Flower> flowers) {
        this.originalFlowers = List.copyOf(flowers);
    }

    @Override
    public List<Flower> sort(Comparator<Flower> comparator) {
        return originalFlowers.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Flower> sort() {
        return originalFlowers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public List<Flower> sortedByFreshness() {
        return sort(Comparator.comparingInt(Flower::getFreshnessLevel).reversed());
    }

    @Override
    public List<Flower> sortedByStemLength() {
        return sort(Comparator.comparingDouble(Flower::getStemLength));
    }
}
