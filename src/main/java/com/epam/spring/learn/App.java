package com.epam.spring.learn;

import com.epam.spring.learn.actions.ConsoleEventLoggerImpl;
import com.epam.spring.learn.entities.Client;
import com.epam.spring.learn.entities.Event;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Andrey_Chadov on 5/17/2017.
 */
public class App {


    Client client;

    Event event;

    ConsoleEventLoggerImpl consoleEventLoggerImpl;


    public App(Client client, ConsoleEventLoggerImpl consoleEventLoggerImpl, Event event) {
        this.client = client;
        this.consoleEventLoggerImpl = consoleEventLoggerImpl;
        this.event = event;
    }

    public App() {
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        consoleEventLoggerImpl.logEvent(event);
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        App app = ctx.getBean(App.class, "app");


        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");

    }
}
