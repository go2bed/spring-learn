package com.epam.spring.learn.loggers.impl;

import com.epam.spring.learn.entities.Event;
import com.epam.spring.learn.loggers.EventLogger;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service("fileEventLogger")
public class FileEventLogger implements EventLogger {

    protected File file;

    @Value("${events.file:target/events_log.txt}")
    protected String fileName;

    public FileEventLogger() {
    }

    @PostConstruct
    public void init() throws IOException {
        file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException(
                    "Can't write to file " + fileName);
        } else if (!file.exists()) {
            file.createNewFile();
        }
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
