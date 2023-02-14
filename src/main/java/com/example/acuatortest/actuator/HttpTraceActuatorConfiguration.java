package com.example.acuatortest.actuator;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 開啟http://localhost:8080/actuator/httptrace的功能
 * @author Hoxton on 2023/2/9
 * @since 1.2.0
 */
@Configuration
public class HttpTraceActuatorConfiguration {

    @Bean
    public HttpTraceRepository httpTraceRepository(){
        return new InMemoryHttpTraceRepository();
    }
}
