package com.epam.spring.learn;

import com.epam.spring.learn.loggers.EventLogger;
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


    public App(Client client, EventLogger consoleEventLoggerImpl, Event event) {
        this.client = client;
        this.fileEventLogger = (FileEventLogger) consoleEventLoggerImpl;
        this.event = event;
    }

    public App() {
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        fileEventLogger.logEvent(event);
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        App app = ctx.getBean(App.class, "app");


        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");

    }
}
