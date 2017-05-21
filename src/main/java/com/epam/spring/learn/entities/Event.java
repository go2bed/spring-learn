package com.epam.spring.learn.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


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

    public static boolean isDay() {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        Date eight = null;
        Date five = null;
        try {
            eight = parser.parse("8:00");
            five = parser.parse("17:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date currentDate = new Date();
        if (currentDate.after(eight) && currentDate.before(five)) {
            return true;
        } else {
            return false;
        }

    }


    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", message='" + message + '\'' +  dateFormat.format(date) + '}';
    }
}
