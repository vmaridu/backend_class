package com.vm.springlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJdbcRepositories
public class SpringLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLabApplication.class, args);
    }
}
