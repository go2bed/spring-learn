package com.epam.spring.learn.loggers.impl;

import com.epam.spring.learn.entities.Event;
import com.epam.spring.learn.loggers.EventLogger;

public class ConsoleEventLoggerImpl implements EventLogger {

    public ConsoleEventLoggerImpl() {
    }

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }

}
