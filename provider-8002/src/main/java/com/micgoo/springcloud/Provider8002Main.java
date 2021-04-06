package com.micgoo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Provider8002Main {
    public static void main(String[] args) {
        SpringApplication.run(Provider8002Main.class, args);
    }
}
