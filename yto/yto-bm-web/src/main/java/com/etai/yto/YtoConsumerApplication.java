package com.etai.yto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class YtoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YtoConsumerApplication.class);
    }
}
