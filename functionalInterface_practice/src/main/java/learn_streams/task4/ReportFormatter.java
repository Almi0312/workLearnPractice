package learn_streams.task4;

@FunctionalInterface
public interface ReportFormatter<T> {
    String format(T t);
}
