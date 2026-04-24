package learn_streams.task1;

import edu.umd.cs.findbugs.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ListProcessor {

    /**
     * применяет преобразование к каждому элементу.
     */
    public <T, R> List<R> map(List<T> list, Transformer<T, R> transformer) {
        List<R> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(transformer.transform(t));
        }
        return newList;
    }

    /**
     * оставляет только элементы, удовлетворяющие условию(predicate)
     */
    public <T> List<T> filter(@NonNull List<T> list,
                              @NonNull Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }
        return newList;
    }

    /**
     * выполняет действие для каждого элемента.
     */
    public <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
