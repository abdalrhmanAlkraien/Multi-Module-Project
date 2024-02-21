package com.project.multimodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.project.multimodule")
public class MultiModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiModuleApplication.class, args);
    }

}
