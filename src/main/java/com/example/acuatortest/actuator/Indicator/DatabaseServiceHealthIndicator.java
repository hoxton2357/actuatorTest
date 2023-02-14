package com.example.acuatortest.actuator.Indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author Hoxton on 2023/2/13
 * @since 1.2.0
 */
//@Component
//public class DatabaseServiceHealthIndicator implements HealthIndicator {
//
//    private final String DATABASE_SERVICE= "DatabaseService";
//
//    @Override
//    public Health health() {
//        if (isDatabaseHealthGood()) {
//            return Health.up().withDetail(DATABASE_SERVICE,"Service is running").build();
//        }
//        return Health.down().withDetail(DATABASE_SERVICE, "Service is not available").build();
//
//    }
//
//    private boolean isDatabaseHealthGood(){
//        //logic
//        return true;
//    }
//}
