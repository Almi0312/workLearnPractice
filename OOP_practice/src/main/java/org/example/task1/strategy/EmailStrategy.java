package org.example.task1.strategy;

public class EmailStrategy implements NotificationStrategy {

    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
