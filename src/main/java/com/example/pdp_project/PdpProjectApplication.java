package com.example.pdp_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class PdpProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdpProjectApplication.class, args);
    }

}
