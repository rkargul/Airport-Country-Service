package com.assignment.lunatech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LunatechApplication {

    private static final Logger log = LoggerFactory.getLogger(LunatechApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(LunatechApplication.class, args);
    }
}
