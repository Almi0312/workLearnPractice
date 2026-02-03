package org.example.blinov.glava4.flowers.utils;

import java.util.Comparator;
import java.util.List;

public interface Sortable<T> {

    List<T> sort(Comparator<T> comparator);

    List<T> sort();
}
