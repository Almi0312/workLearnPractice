package org.example.blinov.glava4.flowers.client;

import org.example.blinov.glava4.flowers.client.flowers_impl.FlowerOperationsImpl;
import org.example.blinov.glava4.flowers.client.flowers_impl.FlowerSearch;
import org.example.blinov.glava4.flowers.client.flowers_impl.FlowerSort;
import org.example.blinov.glava4.flowers.dto.flowers.Flower;

import java.util.List;

public interface FlowerOperations {

    FlowerSort toSort();

    FlowerSearch toSearch();

    static FlowerOperations of(List<Flower> flowers) {
        return new FlowerOperationsImpl(flowers);
    }

}
