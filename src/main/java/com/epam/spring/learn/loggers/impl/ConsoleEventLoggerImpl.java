package com.epam.spring.learn.loggers.impl;

import com.epam.spring.learn.entities.Event;
import com.epam.spring.learn.loggers.EventLogger;

/**
 * Created by Andrey_Chadov on 5/17/2017.
 */
public class ConsoleEventLoggerImpl implements EventLogger {

    public ConsoleEventLoggerImpl() {
    }

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }

}
