package org.example.blinov.glava3.student.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String dateByPattern(LocalDate localDate, DatePattern pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern.pattern));
    }

    public enum DatePattern {
        DEFAULT("dd.MM.yyyy");

        public String pattern;

        DatePattern(String pattern) {
            this.pattern = pattern;
        }
    }
}
