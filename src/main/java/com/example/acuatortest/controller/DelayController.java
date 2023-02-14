package com.example.acuatortest.controller;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Hoxton on 2023/2/8
 * @since 1.2.0
 */
@RestController
public class DelayController {
    Gson gson = new Gson();
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/data")
    public ResponseEntity<String> getDataFromAPI() {
            String url = "http://localhost:8080/actuator/metrics/disk.total";
        return restTemplate.getForEntity(url, String.class);
    }
}
