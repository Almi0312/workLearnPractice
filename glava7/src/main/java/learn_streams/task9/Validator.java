package learn_streams.task9;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Validator {

    public List<Person> isAdult(List<Person> people) {
        return filter(people, p -> p.getAge() >= 18);
    }

    public List<Person> isRetired(List<Person> people) {
        return filter(people, p -> p.getAge() >= 65);
    }

    public List<Person> hasNameLongerThan5(List<Person> people) {
        return filter(people, p -> p.getName().length() > 5);
    }

    public List<Person> isNameStartsWith(List<Person> people, String nameStartWith) {
        return filter(people, p -> p.getName().startsWith(nameStartWith));
    }

    public static List<Person> filter(List<Person> list, Predicate<Person> predicate) {
        List<Person> filtering = new ArrayList<>();
        for (Person person : list) {
            if (predicate.test(person)) {
                filtering.add(person);
            }
        }
        return filtering;
    }


    @Data
    @AllArgsConstructor
    public static class Person {
        String name;
        int age;

    }
}
