package learn_streams.task9;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task9 {
    public static void main(String[] args) {
        Validator validator = new Validator();
        Validator.Person person1 = new Validator.Person("gav", 22);
        Validator.Person person2 = new Validator.Person("gav gav gav", 83);
        Validator.Person person3 = new Validator.Person("aav gav gav gav", 21);
        List<Validator.Person> people = List.of(person1, person2, person3);
        System.out.println(validator.hasNameLongerThan5(people));
        System.out.println(validator.isRetired(people));
        System.out.println(validator.isAdult(people));
        System.out.println(validator.isNameStartsWith(people, "a"));
    }
}
