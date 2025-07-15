package com.sam.zhang.multithread.pool.scenario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PoolApp {
    public static void main(String[] args) {
        SpringApplication.run(PoolApp.class, args);
    }
}
