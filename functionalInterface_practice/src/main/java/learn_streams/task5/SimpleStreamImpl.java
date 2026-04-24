package learn_streams.task5;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleStreamImpl<T> implements SimpleStream<T> {

    private final List<T> data;
    private final List<Operations> postponedOperations;

    public SimpleStreamImpl(List<T> list) {
        this.data = new ArrayList<>(list);
        postponedOperations = new ArrayList<>();
    }

    @Override
    public SimpleStreamImpl<T> filter(Predicate<T> predicate) {
        postponedOperations.add(obj -> predicate.test((T) obj) ? obj : null);
        return this;
    }

//    @Override
    public <R> SimpleStreamImpl<R> map(Function<T, R> mapper) {
        postponedOperations.add(obj -> mapper.apply((T) obj));
        return null;
    }

    @Override
    public void forEach(Consumer<T> consumer) {
        for (T t : this.data) {
            consumer.accept(t);
        }
    }

    @Override
    public List<T> toList() {
        return this.data;
    }

    @FunctionalInterface
    private interface Operations {
        Object apply(Object object);
    }
}
