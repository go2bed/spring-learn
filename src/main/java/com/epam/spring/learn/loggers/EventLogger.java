package com.epam.spring.learn.loggers;

import com.epam.spring.learn.entities.Event;

public interface EventLogger {

    void logEvent(Event event);

}
