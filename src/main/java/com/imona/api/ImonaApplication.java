package com.imona.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {"com.imona"})
@EntityScan(basePackages = {"com.imona"})
@EnableJpaRepositories(basePackages = "com.imona")
public class ImonaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImonaApplication.class, args);
    }

}
