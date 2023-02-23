package com.example.acuatortest;

import com.example.acuatortest.controller.HealthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActuatorTestApplication implements CommandLineRunner {

    HealthController healthController;

    @Autowired
    public void setHealthController(HealthController healthController) {
        this.healthController = healthController;
    }

    public static void main(String[] args) {
        SpringApplication.run(ActuatorTestApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
    }
}
