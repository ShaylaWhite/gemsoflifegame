package com.gemsoflifegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "com.gemsoflifegame.model")
public class GemsofLifeGameApplication {
    public static void main(String[] args) {
        SpringApplication.run(GemsofLifeGameApplication.class, args);
    }
}

