package com.felixwc.publish.eden.blog.enums;

/**
 * in order to learn java!
 * created at 2022/6/19 20:34
 * 系统缓存的唯一前缀
 *
 * @author felixwc
 */
public enum UniqueCacheNamePrefix {

    TOKEN_USERNAME_PREFIX("jwt_user_", "储存已经登录的用户前缀");

    private String value;
    private String description;

    UniqueCacheNamePrefix(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
