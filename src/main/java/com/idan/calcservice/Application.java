package com.idan.calcservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

/**
 * Created by idan on 11/20/14.
 */
@EnableAutoConfiguration
@EnableIntegration
@Configuration
@ComponentScan
@ImportResource("integration-context-mongo.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
