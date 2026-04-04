package learn_streams.task3;

import java.util.function.Supplier;

public class Lazy<T> {

    private final Supplier<T> supplier;
    private volatile T result;

    public Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
        System.out.println("Lazy был создан");
    }

    public T get() {
        synchronized (this) {
            if (isInitialized()) {
                return this.result;
            }
            this.result = supplier.get();
            return this.result;
        }
    }

    private boolean isInitialized() {
        return this.result != null;
    }
}
