package com.example.demo.web.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by wanglei on 2017/5/23.
 */
@Component
public class RocketMQHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("Error code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        return 0;
    }
}
