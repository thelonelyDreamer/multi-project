package com.felixwc.publish.eden.blog.mapper.blog;

import com.felixwc.publish.eden.blog.pojo.data.blog.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagMapperTest {

    @Autowired
    private TagMapper mapper;

    @Test
    void getAllTag() {
        Set<Tag> allTag = mapper.getAllTag();
        allTag.stream().forEach(System.out::println);
    }

    @Test
    void obtainTagById() {
        Tag tag = mapper.obtainTagById(5L);
        System.out.println(tag);
    }
}