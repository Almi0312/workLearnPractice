package org.example.blinov.glava6.candies.interfaces;

import org.example.blinov.glava6.candies.anno.FindBy;
import org.example.blinov.glava6.candies.entity.Brand;
import org.example.blinov.glava6.candies.entity.Candy;

import java.util.Optional;

public interface Findable {

    @FindBy(fields = Candy.CandyField.name)
    Optional<Candy> findCandyByName(String name);

    @FindBy(fields = {Candy.CandyField.name, Candy.CandyField.brand})
    Optional<Candy> findCandyByNameAndBrend(String name, Brand brand);

}
