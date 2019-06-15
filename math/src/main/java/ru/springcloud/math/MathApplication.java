package ru.springcloud.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MathProperties.class)
public class MathApplication {
    public static void main(String[] args) {
        SpringApplication.run(MathApplication.class, args);
    }
}
