package com.etai.okd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@EnableDiscoveryClient
@SpringBootApplication
@PropertySource("config.properties")
@EnableFeignClients
//@EnableCircuitBreaker
public class OkdConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OkdConsumerApplication.class);
    }
}