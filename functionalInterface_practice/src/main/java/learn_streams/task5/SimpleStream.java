package learn_streams.task5;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface SimpleStream<T> {

    static <T> SimpleStreamImpl<T> of(List<T> tList) {
        return new SimpleStreamImpl<>(tList);
    }

    SimpleStreamImpl<T> filter(Predicate<T> predicate);

//    <R> SimpleStreamImpl<R> map(Function<T, R> mapper);

    void forEach(Consumer<T> consumer);

    List<T> toList();
}
