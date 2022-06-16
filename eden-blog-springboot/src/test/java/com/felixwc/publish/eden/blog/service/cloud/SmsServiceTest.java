package com.felixwc.publish.eden.blog.service.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SmsServiceTest {
    @Autowired
    SmsService smsService;
    @Value("${my.phone.number}")
    private String phoneNumber;
    @Test
    void sendValidatedCode() {
        for (int i = 0; i < 3; i++) {
            smsService.sendValidatedCode(phoneNumber,6);
        }
    }
}