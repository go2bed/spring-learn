package com.epam.spring.learn.actions;

import com.epam.spring.learn.entities.Event;

/**
 * Created by Andrey_Chadov on 5/17/2017.
 */
public interface ConsoleEventLogger {

    void logEvent(Event event);

}
