package com.practice.demo.springsocialmedia;

import com.practice.demo.springsocialmedia.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class SpringSocialMediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSocialMediaApplication.class, args);
    }

}
