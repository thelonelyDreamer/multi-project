package com.felixwc.publish.eden.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.util.Arrays;

@SpringBootApplication
@EnableCaching
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class BlogApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BlogApplication.class, args);
        Arrays.stream(context.getBeanNamesForType(Cache.class))
                .forEach(System.out::println);
    }
}