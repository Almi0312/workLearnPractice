package learn_streams.task2;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Должно вывестись
 * 6
 * 11
 * 21
 */
public class Task2 {

    public static void main(String[] args) {
        rightResult();
        myResult();
    }

    private static void rightResult() {
        Function<Integer, Integer> add5 = x -> getCarryFunc().apply(5).apply(x).apply(0);
        Function<Integer, Integer> add10 = x -> getCarryFunc().apply(10).apply(x).apply(0);
        System.out.println(add5.apply(5));        // 10? Нет: 5+5+0=10
        System.out.println(add10.apply(10));      // 10+10+0=20
        System.out.println(add5.andThen(add10).apply(3)); // (3+5+0)+10+0 = 8+10=18
        System.out.println("Далее мой результат:");
    }

    private static void myResult() {
        Function<Integer, Integer> add5 =
                x -> getCarryFunc().apply(1).apply(2).apply(3) + x;
        System.out.println(add5.apply(5));

        Function<Integer, Function<Integer, Integer>> add5And10 =
                x -> y -> FunctionUtils.chain(add5, z -> z + y).apply(x);
        System.out.println(add5And10.apply(5).apply(10));
        Function<Integer, Function<Integer, Integer>> add5And10_2 =
                x -> y -> add5.andThen(z -> z + y).apply(x);
        System.out.println(add5And10_2.apply(5).apply(10));
    }

    private static Function<Integer, Function<Integer, Function<Integer, Integer>>> getCarryFunc() {
        return x -> y -> z -> x + y + z;
    }
}
