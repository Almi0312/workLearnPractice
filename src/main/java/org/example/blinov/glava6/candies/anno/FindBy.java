package org.example.blinov.glava6.candies.anno;

import org.example.blinov.glava6.candies.entity.Candy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FindBy {
    Candy.CandyField[] fields();

    boolean multiple() default false;
}
