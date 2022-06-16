package com.felixwc.publish.eden.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootTest
class BlogApplicationTest {
    @Autowired
    private ApplicationContext context;

    @Value("${jacyptp.name:shine}")
    private String myName;

    @Autowired
    private DataSource dataSource;

    /**
     * 开发环境测试集成度用的
     */
    @Test
    public void test(){
        System.out.println(myName);
    }

    /**
     *  获取容器内所有bean的名字
     */
    @Test
    public void test1() {
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     *  获取指定类型bean的名字
     */
    @Test
    public void test2(){
        Arrays.stream(context.getBeanNamesForType(CacheManager.class)).forEach(System.out::println);
    }

    @Test
    public void testDataSource(){
        System.out.println(dataSource);
    }
}