package org.example.task1.strategy;

public class PushStrategy implements NotificationStrategy {
    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
