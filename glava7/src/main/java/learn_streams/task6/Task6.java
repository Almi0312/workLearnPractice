package learn_streams.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Task6 {
    public static void main(String[] args) {
        List<String> strings = List.of("pupupu", "mimimi  ", "  uauaua", " cat ", "dog", "monkey");
        System.out.println(transformStrings(strings, String::toUpperCase));
        System.out.println(transformStrings(strings, String::trim));
        System.out.println(transformStrings(strings, x -> "Prefix: " + x));
    }

    private static List<String> transformStrings(List<String> strings, Function<String, String> transformer) {
        List<String> newStrings = new ArrayList<>();
        strings.forEach(x -> newStrings.add(transformer.apply(x)));
        return newStrings;
    }
}
