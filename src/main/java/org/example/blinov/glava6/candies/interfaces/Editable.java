package org.example.blinov.glava6.candies.interfaces;

import edu.umd.cs.findbugs.annotations.NonNull;
import org.example.blinov.glava6.candies.entity.Brand;
import org.example.blinov.glava6.candies.entity.Candy;
import org.example.blinov.glava6.candies.entity.Chocolate;
import org.example.blinov.glava6.candies.entity.Ingredient;

import java.util.List;

public interface Editable {

    Chocolate addChocolateCandy(@NonNull String name,
                                @NonNull Brand brand,
                                @NonNull double weight,
                                @NonNull List<Ingredient> ingredients,
                                @NonNull int quantityStock,
                                @NonNull String cocoaPercentage);

    Candy editCandy(Candy candy);
}
