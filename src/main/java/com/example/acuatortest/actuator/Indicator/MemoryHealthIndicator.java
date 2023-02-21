package com.example.acuatortest.actuator.Indicator;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;

/**
 * @author Hoxton on 2023/2/13
 * @since 1.2.0
 */
@Component
public class MemoryHealthIndicator implements HealthIndicator {

    private final OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    @Override
    public Health health() {
        long totalPhysicalMemorySize = osBean.getTotalPhysicalMemorySize();
        long freePhysicalMemorySize = osBean.getFreePhysicalMemorySize();
        long usedPhysicalMemorySize=totalPhysicalMemorySize -freePhysicalMemorySize;
        long userRation = usedPhysicalMemorySize / totalPhysicalMemorySize;

        if (userRation<0.8d){
            return Health.up()
                    .withDetail("totalPhysicalMemorySize", totalPhysicalMemorySize)
                    .withDetail("freePhysicalMemorySize",freePhysicalMemorySize)
                    .withDetail("usedPhysicalMemorySize",usedPhysicalMemorySize)
                    .build();
        }else {
            return Health.down()
                    .withDetail("totalPhysicalMemorySize", totalPhysicalMemorySize)
                    .withDetail("freePhysicalMemorySize",freePhysicalMemorySize)
                    .withDetail("usedPhysicalMemorySize",usedPhysicalMemorySize)
                    .build();
        }



    }

    private boolean isDatabaseHealthGood(){
        //logic
        return true;
    }
}
