package org.example.task2.loggers;

import org.example.task2.Logger;

public class FileLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
