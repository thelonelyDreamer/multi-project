package com.felixwc.publish.eden.blog.service.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlibabaSMSServiceImplTest {
    @Autowired
    private AlibabaSMSServiceImpl service;
    @Value("${my.phone.number}")
    private String number;

    @Test
    void sendCodeToOneNumberTest(){

    }

}