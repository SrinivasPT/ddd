package com.edge.kernel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EntityScan
@EnableJpaRepositories
@EnableScheduling
public class KernelApplication {
    public static void main(String[] args) {
        SpringApplication.run(KernelApplication.class, args);
    }

}
