package org.example.task2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampDecorator extends LoggerDecorator implements Logger {

    public TimestampDecorator(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        getLogger().log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh:ss:mm")) + ": " + message);
    }
}
