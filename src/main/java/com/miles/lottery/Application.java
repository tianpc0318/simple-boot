package com.miles.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.miles.lottery")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
