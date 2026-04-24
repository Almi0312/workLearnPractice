package learn_streams.task8;

import learn_streams.task7.User;

import java.util.function.Function;
import java.util.function.Predicate;

public class Task8 {
    public static void main(String[] args) {
        Predicate<Integer> isGreaterThan10 = checkNumber().apply(10);
        Predicate<Integer> isGreaterThan100 = checkNumber().apply(100);
        System.out.println(isGreaterThan10.test(20));
        System.out.println(isGreaterThan10.test(2));
        System.out.println(isGreaterThan100.test(200));
        System.out.println(isGreaterThan100.test(20));
    }

    private static Function<Integer, Predicate<Integer>> checkNumber() {
        return x -> y -> y > x;
    }
}
