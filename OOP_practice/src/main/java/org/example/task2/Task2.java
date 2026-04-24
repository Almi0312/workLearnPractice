package org.example.task2;

import org.example.task2.loggers.ConsoleLogger;

public class Task2 {
    public static void main(String[] args) {
        LoggerDecorator loggerDecorator = new TimestampDecorator(new LevelDecorator(new ConsoleLogger()));
        new TimestampDecorator(new LevelDecorator(new ConsoleLogger())).log("pupupu");
    }
}
