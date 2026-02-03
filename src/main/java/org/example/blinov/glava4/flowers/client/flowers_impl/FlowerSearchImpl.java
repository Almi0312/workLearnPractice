package org.example.blinov.glava4.flowers.client.flowers_impl;

import org.example.blinov.glava4.flowers.dto.flowers.Flower;
import org.example.blinov.glava4.flowers.dto.flowers.FlowerColor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FlowerSearchImpl implements FlowerSearch {

    private final List<Flower> originalFlowers;

    public FlowerSearchImpl(List<Flower> flowers) {
        this.originalFlowers = List.copyOf(flowers);
    }

    @Override
    public List<Flower> findByStemLengthRange(double minLength, double maxLength) {
        return originalFlowers.stream()
                .filter(flower -> minLength <= flower.getStemLength() && maxLength >= flower.getStemLength())
                .toList();
    }

    @Override
    public <T extends Flower> Optional<T> findByExactStemLength(double stemLength) {
        return (Optional<T>) originalFlowers.stream()
                .filter(flower -> stemLength == flower.getStemLength())
                .findFirst();
    }

    @Override
    public List<Flower> findByFreshness(int minFreshness) {
        return originalFlowers.stream()
                .filter(flower -> minFreshness == flower.getFreshnessLevel())
                .toList();
    }

    @Override
    public List<Flower> findByColor(FlowerColor color) {
        return originalFlowers.stream()
                .filter(flower -> Objects.equals(color.color, flower.getFlowerColor()))
                .toList();
    }

    @Override
    public List<Flower> findByName(String name) {
        return originalFlowers.stream()
                .filter(flower -> name.equals(flower.getName()))
                .toList();
    }
}
