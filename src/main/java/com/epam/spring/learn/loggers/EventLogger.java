package com.epam.spring.learn.loggers;

import com.epam.spring.learn.entities.Event;

/**
 * Created by Andrey_Chadov on 5/17/2017.
 */
public interface EventLogger {

    void logEvent(Event event);

}
