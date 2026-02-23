package org.example.blinov.glava6.candies.proxy;

import org.example.blinov.glava6.candies.anno.FindBy;
import org.example.blinov.glava6.candies.data.Data;
import org.example.blinov.glava6.candies.entity.Candy;
import org.example.blinov.glava6.candies.service.CandyManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.String.format;

public class CandyManageHandler implements InvocationHandler {
    private final CandyManager target;

    private static final Map<Candy.CandyField, Method> fieldGetters = new HashMap<>();

    public CandyManageHandler(CandyManager target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return Optional.ofNullable(method.getAnnotation(FindBy.class)).map(anno -> {
            if (args.length != anno.fields().length) {
                throw new IllegalArgumentException("Количество аргументов не соответствует количеству полей");
            }
            if (anno.multiple()) {
                return getCandyFilter(args, anno.fields()).toList();
            } else {
                return getCandyFilter(args, anno.fields()).findFirst();
            }
        }).orElse(method.invoke(target, args));
    }

    private Stream<Candy> getCandyFilter(Object[] args, Candy.CandyField[] candyFields) {
        return Data.candies.stream().filter(candy -> {
            boolean matchResult = false;
            for (int i = 0; i < args.length; i++) {
                matchResult = Objects.equals(args[i], getValueByGetter(candy, candyFields[i]));
            }
            return matchResult;
        });
    }

    private Object getValueByGetter(Candy candy, Candy.CandyField candyField) {
        try {
            return fieldGetters.computeIfAbsent(candyField, x ->
                            getGetterMethodByCandyField(candyField))
                    .invoke(candy);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(format("Не удалось получить значение поля %s из класса %s.\n%s",
                    candyField.name(), candy.getClass().getSimpleName(), e));
        }
    }

    private static Method getGetterMethodByCandyField(final Candy.CandyField candyField) {
        try {
            String getter = format("get%s%s", candyField.name().substring(0, 1).toUpperCase(), candyField.name().substring(1));
            return Candy.class.getMethod(getter);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Геттера для поля " + candyField.name() + " не существует.");
        }
    }
}
