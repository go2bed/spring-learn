package com.epam.spring.learn;

import com.epam.spring.learn.loggers.EventLogger;
import com.epam.spring.learn.loggers.impl.CacheFileEventLogger;
import com.epam.spring.learn.loggers.impl.ConsoleEventLoggerImpl;
import com.epam.spring.learn.entities.Client;
import com.epam.spring.learn.entities.Event;
import com.epam.spring.learn.loggers.impl.FileEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {


    Client client;

    Event event;

    ConsoleEventLoggerImpl consoleEventLoggerImpl;

    FileEventLogger fileEventLogger;

    CacheFileEventLogger cacheFileEventLogger;


    public App(Client client, EventLogger consoleEventLoggerImpl, Event event) {
        this.client = client;
        this.fileEventLogger = (CacheFileEventLogger) consoleEventLoggerImpl;
        this.event = event;
    }

    public App() {
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        for (int i = 0; i < 7 ; i++) {
            fileEventLogger.logEvent(event);
        }
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        App app = ctx.getBean(App.class, "app");


        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");

    }
}
