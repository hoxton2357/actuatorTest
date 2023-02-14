package com.example.acuatortest.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hoxton on 2023/2/13
 * @since 1.2.0
 */
@Endpoint(id = "custom")
@Component
public class CustomActuatorEndpoint {

    @ReadOperation
    public Object customEndPoint(String username) {
        Map<String, String> map = new HashMap<>();
        map.put("key", "Value");
        map.put("Username", username);
        return map;
    }
}
