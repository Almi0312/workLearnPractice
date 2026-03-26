package org.example.blinov.glava6.candies.utils;

import org.example.blinov.glava6.candies.anno.NotNull;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;

public class NotNullAnnoUtils {

    public static void checkWhatFieldNonNull(Object obj) {
        for (Field field : ReflectionUtils.getAllFields(obj.getClass())) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(obj) == null) {
                        throw new IllegalArgumentException(
                                "Поле '" + field.getName() + "' не должно быть null");
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
