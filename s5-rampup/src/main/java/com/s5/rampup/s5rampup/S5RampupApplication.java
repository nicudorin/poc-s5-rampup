package com.s5.rampup.s5rampup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource("/applicationContext.xml")
@PropertySource("/application.properties")
public class S5RampupApplication {

    public static void main(String[] args) {
        SpringApplication.run(S5RampupApplication.class, args);
    }
}
