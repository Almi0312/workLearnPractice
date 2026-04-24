package learn_streams.task10;

import java.util.function.Function;

public class Cache<K, V> {
    Function<K, V> calculator;

    public Cache(Function<K, V> calculator) {
        this.calculator = calculator;
    }

    public V get(K key) {
        return calculator.apply(key);
    }
}
