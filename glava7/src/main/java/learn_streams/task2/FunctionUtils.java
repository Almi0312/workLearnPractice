package learn_streams.task2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionUtils {

    /**
     * возвращает композицию двух функций (это аналог first.andThen(second)).
     */
    static <T, U, V> Function<T, V> chain(Function<T, U> first, Function<U, V> second) {
        return t -> second.apply(first.apply(t));
    }

    static <T, U, V> Function<T, Function<U, V>> curry3(BiFunction<T, U, V> biFunc) {
        return t -> z -> biFunc.apply(t, z);
    }
}
