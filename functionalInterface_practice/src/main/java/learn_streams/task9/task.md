### Задача R1. Рефакторинг валидаторов
Дан класс `Validator` с дублирующимися методами:

```java
public class Validator {
public boolean isAdult(Person p) {
return p.getAge() >= 18;
}
public boolean isRetired(Person p) {
return p.getAge() >= 65;
}
public boolean hasNameLongerThan5(Person p) {
return p.getName().length() > 5;
}
}
```
#### Твоя задача:
создать общий метод `List<Person> filter(List<Person> list, Predicate<Person> predicate)` и переписать три метода так, чтобы они использовали этот общий метод и подходящие лямбды.
Покажи, как теперь легко добавить новый критерий (например, `isNameStartsWithA`).
