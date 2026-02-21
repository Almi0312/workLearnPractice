package org.example.blinov.glava4.flowers.client.flowers_impl;

import org.example.blinov.glava4.flowers.utils.Sortable;
import org.example.blinov.glava4.flowers.dto.flowers.Flower;

import java.util.Comparator;
import java.util.List;

public interface FlowerSort extends Sortable<Flower> {

    List<Flower> sort(Comparator<Flower> comparator);

    List<Flower> sort(); // естественная сортировка

    List<Flower> sortedByFreshness();

    List<Flower> sortedByStemLength();

}
