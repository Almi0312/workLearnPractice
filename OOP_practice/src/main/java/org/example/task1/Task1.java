package org.example.task1;

import org.example.task1.strategy.EmailStrategy;
import org.example.task1.strategy.PushStrategy;
import org.example.task1.strategy.SmsStrategy;
import org.example.task1.strategy.TelegramStrategy;

public class Task1 {
    public static void main(String[] args) {
        new NotificationService(new EmailStrategy()).sendMessage("Это email стратегия");
        new NotificationService(new SmsStrategy()).sendMessage("Это sms стратегия");
        new NotificationService(new PushStrategy()).sendMessage("Это push стратегия");
        new NotificationService(new TelegramStrategy()).sendMessage("Это telegram стратегия");
    }
}
