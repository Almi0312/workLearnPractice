package org.example.task1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.task1.strategy.NotificationStrategy;

@Data
@AllArgsConstructor
public class NotificationService {

    private NotificationStrategy notificationStrategy;

    public void sendMessage(String message) {
        notificationStrategy.send(message);
    }
}
