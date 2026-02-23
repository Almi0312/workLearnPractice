package org.example.blinov.glava6.candies.interfaces;

import org.example.blinov.glava6.candies.entity.Candy;

public interface Editable {

    Candy addCandy(Candy candy);

    Candy editCandy(Candy candy);
}
