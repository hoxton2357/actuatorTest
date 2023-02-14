package com.example.acuatortest.actuator.Indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author Hoxton on 2023/2/13
 * @since 1.2.0
 */
//@Component
//public class LoggerServiceHealthIndicator implements HealthIndicator {
//    private final String LOGGER_SERVICE = "DatabaseService";
//
//    @Override
//    public Health health() {
//        if (isLoggerServiceGood()) {
//            return Health.up().withDetail(LOGGER_SERVICE,"Service is running").build();
//        }
//        return Health.down().withDetail(LOGGER_SERVICE, "Service is not abailable").build();
//    }
//
//    private boolean isLoggerServiceGood(){
//        //logic
//        return false;
//    }
//}
