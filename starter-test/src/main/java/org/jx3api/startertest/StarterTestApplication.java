package org.jx3api.startertest;

import jx3api.api.config.EnableJX3Api;
import jx3api.api.config.EnableJX3ApiWS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.jx3api","jx3api.api"})
@EnableJX3Api
public class StarterTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterTestApplication.class, args);
    }

}
