package com.micgoo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Provider8004Main {
    public static void main(String[] args) {
        SpringApplication.run(Provider8004Main.class, args);
    }
}
