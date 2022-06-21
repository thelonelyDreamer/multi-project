package com.felixwc.publish.eden.blog.config.properties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JWTPropertiesTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void test(){
        System.out.println(context.getBean(JWTProperties.class));
    }
}