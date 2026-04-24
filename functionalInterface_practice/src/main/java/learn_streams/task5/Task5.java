package learn_streams.task5;

import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        SimpleStream.of(List.of(1, 2, 3, 4, 5))
                .filter(x -> x % 2 == 0)
//                .map(x -> x * x)
                .forEach(System.out::println); // должно вывести 4, 16
    }
}
