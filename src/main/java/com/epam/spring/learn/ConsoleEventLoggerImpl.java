package com.epam.spring.learn;

/**
 * Created by Andrey_Chadov on 5/17/2017.
 */
public class ConsoleEventLoggerImpl implements ConsoleEventLogger {


    public ConsoleEventLoggerImpl() {
    }

    public void logEvent(String msg) {
        System.out.println(msg);
    }

}
