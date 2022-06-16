package com.felixwc.publish.eden.blog.mapper;

import com.felixwc.publish.eden.blog.pojo.data.blog.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonMapperTest {
    @Autowired
    private PersonMapper mapper;

    @Test
    public void test(){
        for (Person person : mapper.getAllPerson()) {
            System.out.println(person);
        }

    }
}