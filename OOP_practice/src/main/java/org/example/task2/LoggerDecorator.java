package org.example.task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class LoggerDecorator {
    private Logger logger;
}
