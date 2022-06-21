package com.felixwc.publish.eden.blog.config;

import com.felixwc.publish.eden.blog.config.properties.JWTProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * in order to learn java!
 * created at 2022/6/18 17:01
 *
 * @author felixwc
 */
@EnableConfigurationProperties({JWTProperties.class})
@Configuration
public class JWTConfig {
}
