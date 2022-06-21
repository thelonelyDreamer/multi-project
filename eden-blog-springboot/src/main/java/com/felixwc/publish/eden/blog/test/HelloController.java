package com.felixwc.publish.eden.blog.test;

import com.felixwc.publish.eden.blog.pojo.vo.CommonResult;
import com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder;
import com.felixwc.publish.eden.blog.pojo.vo.state.CommonState;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;

/**
 * in order to learn java!
 * created at 2022/6/16 12:10
 *
 * @author felixwc
 */
@RestController
@RequestMapping("test")
public class HelloController {
    @GetMapping("/hello/default")
    public String sayHello0() {
        return "default";
    }
    @GetMapping("/hello/hello")
    @PermitAll
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/hello/hello1")
    @DenyAll
    public String sayHello1() {
        return "hello1";
    }

    @GetMapping("/hello/hello2")
    @Secured({"ROLE_admin"})
    public String sayHello2() {
        return "hello2";
    }

    @GetMapping("/hello/hello3")
    @Secured({"ROLE_test"})
    public String sayHello3() {
        return "hello3";
    }

    @GetMapping("/hello/hello4")
    @PreAuthorize("hasRole('admin')")
    public String sayHello4() {
        return "hello4";
    }

    @GetMapping("/hello/hello5")
    @PreAuthorize("hasRole('admin') ")
    public String sayHello5() {
        return "hello4";
    }


    @GetMapping("/hello/person")
    @PermitAll
    public CommonResult<Person> getPerson() {
        CommonResultBuilder<Person> builder = new CommonResultBuilder<>();
        Person person = new Person()
                .setId(123332L)
                .setAge(13)
                .setName("shine");

        builder.startBuilder()
                .setCode(CommonState.SUCCESS.getCode())
                .setData(person);
        return builder.build();
    }

    @Data
    @ApiModel
    @Accessors(chain = true)
    public static class Person {
        Long id;
        String name;
        Integer age;

    }
}
