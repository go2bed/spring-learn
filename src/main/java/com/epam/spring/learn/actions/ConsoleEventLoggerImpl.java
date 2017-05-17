package com.epam.spring.learn.actions;

import com.epam.spring.learn.entities.Event;

/**
 * Created by Andrey_Chadov on 5/17/2017.
 */
public class ConsoleEventLoggerImpl implements ConsoleEventLogger {

    public ConsoleEventLoggerImpl() {
    }

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }

}
