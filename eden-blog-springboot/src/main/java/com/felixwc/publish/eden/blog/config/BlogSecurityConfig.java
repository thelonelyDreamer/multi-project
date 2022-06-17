package com.felixwc.publish.eden.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * in order to learn java!
 * created at 2022/6/15 12:21
 *
 * @author felixwc
 */
@Configuration
public class BlogSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin();
        http.authorizeHttpRequests()
                .antMatchers("/swagger-ui/**","/druid/**")
                .hasAnyRole("admin","dev");
    }
}
