package com.epam.spring.learn.loggers.impl;


import com.epam.spring.learn.entities.Event;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("cacheFileEventLogger")
public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(int cacheSize, String fileName) {
        this.cacheSize = cacheSize;
        super.setFileName(fileName);
    }

    public CacheFileEventLogger() {
    }

    @Override
    public void logEvent(Event event) {
        if (event != null) {
            cache.add(event);
            if (cache.size() == cacheSize) {
                writeEventsFromCache(cache);
                cache.clear();
            }
        }
    }

    private void writeEventsFromCache(List<Event> cache) {
        try {
            FileUtils.writeStringToFile(file, cache.toString(), true);
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Невозможно записать данные в файл " + e.getMessage());
        }
    }

    @PreDestroy
    public void destroy() {
        if (!cache.isEmpty() || cache != null) {
            writeEventsFromCache(cache);
        }
    }

}
