package com.felixwc.publish.eden.blog.mapper;

import com.felixwc.publish.eden.blog.pojo.data.blog.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * in order to learn java!
 * created at 2022/6/13 16:18
 *
 * @author felixwc
 */
@Mapper
public interface PersonMapper {
    List<Person> getAllPerson();
}
