package com.epam.spring.learn;

/**
 * Created by Andrey_Chadov on 5/17/2017.
 */
public class App {

    Client client;
    ConsoleEventLogger consoleEventLogger;

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        consoleEventLogger.logEvent(message);
    }

    public static void main(String[] args) {

        App app = new App();

        app.client = new Client("1", "John Smith");
        app.consoleEventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user 1");

    }
}
