package com.example.store.bookshop.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Testy {
    Logger logger = LoggerFactory.getLogger(Testy.class);

    @Scheduled(fixedRate = 2000)
    @Async
    public void printEvery5Secs() throws InterruptedException {
        Thread.sleep(6000);
        logger.info("I am supposed to be print every 5 seconds {}", LocalDateTime.now());
    }

}
