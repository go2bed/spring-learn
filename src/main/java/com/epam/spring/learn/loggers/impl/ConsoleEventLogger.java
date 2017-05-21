package com.epam.spring.learn.loggers.impl;

import com.epam.spring.learn.entities.Event;
import com.epam.spring.learn.loggers.EventLogger;
import org.springframework.stereotype.Component;

@Component
public class ConsoleEventLogger implements EventLogger {

    public ConsoleEventLogger() {
    }

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }

}
