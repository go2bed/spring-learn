package com.epam.spring.learn.loggers.impl;

import com.epam.spring.learn.entities.Event;
import com.epam.spring.learn.loggers.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    protected File file;
    protected String fileName;

    public FileEventLogger() {
    }

    public void init() throws IOException {
        this.file = new File(fileName);
    }


    @Override
    public void logEvent(Event event) {
        writeEvetnsToFile(event);
    }

    private void writeEvetnsToFile(Event event) {
        try {
            System.out.println(event + " This event");
            FileUtils.writeStringToFile(file,event.toString(),true);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно записать данные в файл " + e.getMessage());
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
