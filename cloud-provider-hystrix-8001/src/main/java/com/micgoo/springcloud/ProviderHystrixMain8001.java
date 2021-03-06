package com.micgoo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ProviderHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixMain8001.class, args);
    }
}
