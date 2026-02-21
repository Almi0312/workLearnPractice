package org.example.blinov.glava4.flowers.client.flowers_impl;

import org.example.blinov.glava4.flowers.dto.flowers.Flower;
import org.example.blinov.glava4.flowers.dto.flowers.FlowerColor;

import java.util.List;
import java.util.Optional;

public interface FlowerSearch {
    List<Flower> findByStemLengthRange(double minLength, double maxLength);

    <T extends Flower> Optional<T> findByExactStemLength(double stemLength);

    List<Flower> findByFreshness(int minFreshness);

    List<Flower> findByColor(FlowerColor color);

    List<Flower> findByName(String name);
}
