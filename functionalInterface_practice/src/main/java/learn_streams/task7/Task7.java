package learn_streams.task7;

import java.util.function.Function;

public class Task7 {
    public static void main(String[] args) {
        User user = new User("Petr1", 12);
        System.out.println(getUserUpperName().apply(user));
        System.out.println(getLengthByString().apply(user.getName()));
        System.out.println(getUserUpperName().andThen(getLengthByString()).apply(user));
        System.out.println(getLengthByString().compose(getUserUpperName()).apply(user));
        System.out.println(compose(getUserUpperName(), getLengthByString()).apply(user));

    }

    private static Function<User, String> getUserUpperName() {
        return user -> user.getName().toUpperCase();
    }

    private static Function<String, Integer> getLengthByString() {
        return String::length;
    }

    private static <T, U, V> Function<T, V> compose(Function<T, U> function1, Function<U, V> function2) {
        return t -> function2.apply(function1.apply(t));
    }
}
