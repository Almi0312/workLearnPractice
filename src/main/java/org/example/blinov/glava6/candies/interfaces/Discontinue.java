package org.example.blinov.glava6.candies.interfaces;

import org.example.blinov.glava6.candies.entity.Brand;

/**
 * Контракт на снятие с продажи
 */
public interface Discontinue {

    void discontinueCandy(String name, Brand brand);
}
