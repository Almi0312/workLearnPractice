package org.example.task2;

public class LevelDecorator extends LoggerDecorator implements Logger {

    private Level level;

    public LevelDecorator(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        this.level = Level.INFO;
        getLogger().log(level + " " + message);
    }

    enum Level {
        ERROR,
        INFO
    }
}
