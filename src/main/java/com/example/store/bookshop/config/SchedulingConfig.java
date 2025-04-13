package com.example.store.bookshop.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
@EnableAsync
public class SchedulingConfig {
}
