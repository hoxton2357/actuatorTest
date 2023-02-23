package com.example.acuatortest.actuator.Indicator;

import com.sun.management.OperatingSystemMXBean;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.management.ManagementFactory;

/**
 * @author Hoxton on 2023/2/13
 * @since 1.2.0
 */
@Component
public class CPUStatusHealthIndicator implements HealthIndicator {
    private final OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    @Override
    public Health health() {
        String arch = osBean.getArch();
        String name = osBean.getName();
        double systemLoadAverage = osBean.getSystemLoadAverage();
        double processCpuLoad = osBean.getSystemCpuLoad();
        if (processCpuLoad < 0.80d) {
            return Health.up().withDetail("processCpuLoad", processCpuLoad)
                    .withDetail("arch", arch)
                    .withDetail("name",name)
                    .withDetail("systemLoadAverage", systemLoadAverage)
                    .withDetail("condition", "if processCpuLoad > 0.8, it will return down")
                    .build();
        } else {
            return Health.down()
                    .withDetail("processCpuLoad", processCpuLoad)
                    .withDetail("arch",arch)
                    .withDetail("condition", "if processCpuLoad > 0.8, it will return down")
                    .build();
        }
    }
}
