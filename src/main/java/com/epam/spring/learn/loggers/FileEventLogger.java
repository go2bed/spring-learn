package com.epam.spring.learn.loggers;

import com.epam.spring.learn.entities.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Andrey_Chadov on 5/17/2017.
 */
public class FileEventLogger implements ConsoleEventLogger{

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
