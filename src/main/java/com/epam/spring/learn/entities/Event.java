package com.epam.spring.learn.entities;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Andrey_Chadov on 5/17/2017.
 */
public class Event {

    private int id = new Random().nextInt();
    private String message;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date=date;
        this.dateFormat=dateFormat;
    }

    public Event() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", message='" + message + '\'' +  dateFormat.format(date) + '}';
    }
}
