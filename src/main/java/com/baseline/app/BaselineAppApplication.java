package com.baseline.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BaselineAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaselineAppApplication.class, args);
    }
}
