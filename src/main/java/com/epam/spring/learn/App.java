package com.epam.spring.learn;

import com.epam.spring.learn.entities.Client;
import com.epam.spring.learn.entities.Event;
import com.epam.spring.learn.entities.EventType;
import com.epam.spring.learn.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


public class App {

    Map<EventType, EventLogger> loggers;

    Client client;

    Event event;

    EventLogger eventLogger;

    EventLogger defaultEventLogger;


    public App(Client client, EventLogger defaultEventLogger,
               Map<EventType, EventLogger> loggers, Event event) {
        this.client = client;
        this.loggers = loggers;
        this.event = event;
        this.defaultEventLogger = defaultEventLogger;
    }

    public App() {
    }

    public void logEvent(EventType eventType, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        System.out.println(client.toString());
        eventLogger = loggers.get(eventType);
        if (eventLogger == null) {
            eventLogger = defaultEventLogger;
        }
        for (int i = 0; i < 7; i++) {
            eventLogger.logEvent(event);
        }
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        App app = ctx.getBean(App.class, "app");


        app.logEvent(EventType.INFO, "Some event for user 1");
        app.logEvent(EventType.ERROR, "Some event for user 2");

    }
}
