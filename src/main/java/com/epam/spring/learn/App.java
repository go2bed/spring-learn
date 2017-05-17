package com.epam.spring.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Andrey_Chadov on 5/17/2017.
 */
public class App {


    Client client;

    ConsoleEventLoggerImpl consoleEventLoggerImpl;


    public App(Client client, ConsoleEventLoggerImpl consoleEventLoggerImpl) {
        this.client = client;
        this.consoleEventLoggerImpl = consoleEventLoggerImpl;
    }

    public App() {
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        consoleEventLoggerImpl.logEvent(message);
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");

        App app = ctx.getBean(App.class, "app");


        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");

    }
}
