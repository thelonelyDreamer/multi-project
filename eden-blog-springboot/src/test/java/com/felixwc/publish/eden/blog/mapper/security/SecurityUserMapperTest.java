package com.felixwc.publish.eden.blog.mapper.security;

import com.felixwc.publish.eden.blog.pojo.security.SecurityUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityUserMapperTest {
    @Autowired
    SecurityUserMapper mapper;

    @Test
    void obtainSecurityUserByNameTest() {
        SecurityUser shine = mapper.obtainSecurityUserByName("shine");
        System.out.println(shine);
    }

    @Test
    void obtainSecurityUserByNameWithRole() {
        SecurityUser shine = mapper.obtainSecurityUserByNameWithRole("mary");
        System.out.println(shine);
    }
}