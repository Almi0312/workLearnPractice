package learn_streams.task1;

@FunctionalInterface
public interface Transformer<T, R> {
    R transform(T input);
}
