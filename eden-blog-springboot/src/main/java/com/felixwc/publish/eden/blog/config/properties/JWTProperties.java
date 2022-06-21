package com.felixwc.publish.eden.blog.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * in order to learn java!
 * created at 2022/6/18 16:56
 *
 * @author felixwc
 */
@ConfigurationProperties(prefix = "felix.jwt")
@Data
public class JWTProperties {
    private String username = "username";
    private String uerId = "user_id";
    private String secret;
    private String head;
    private String prefix;
    private int tokenRemainTime;
}
