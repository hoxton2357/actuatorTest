package com.example.acuatortest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * @author Hoxton on 2023/2/21
 * @since 1.2.0
 */
@Controller
public class HealthController {


    private HealthEndpoint healthEndpoint;

    public HealthController(HealthEndpoint healthEndpoint) {
        this.healthEndpoint = healthEndpoint;
    }

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/app") //類似RequestMapping的作用 client丟 sever 收
    @SendTo("/topic/health") //Channel client 收 server 丟
    @Scheduled(fixedRate = 1000) //one minute
    public HealthComponent health() {
        System.out.println(123);
        simpMessagingTemplate.convertAndSend("/topic/health", healthEndpoint.health());
        return  healthEndpoint.health();
    }

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public String sayHello(){
        return "Hello";
    }
}
