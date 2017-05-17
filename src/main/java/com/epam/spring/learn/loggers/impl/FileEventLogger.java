package com.epam.spring.learn.loggers.impl;

import com.epam.spring.learn.entities.Event;
import com.epam.spring.learn.loggers.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private File file;
    private String fileName;

    public FileEventLogger() {
    }

    public void init() throws IOException {
        this.file = new File(fileName);
    }


    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file,event.toString(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
