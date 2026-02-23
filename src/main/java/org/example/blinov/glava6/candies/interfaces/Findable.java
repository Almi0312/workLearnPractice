package org.example.blinov.glava6.candies.interfaces;

import org.example.blinov.glava6.candies.entity.Brand;
import org.example.blinov.glava6.candies.entity.Candy;

import java.util.Optional;

public interface Findable {

    Optional<Candy> findCandyByName(String name);

    Optional<Candy> findCandyByNameAndBrend(String name, Brand brand);

}
