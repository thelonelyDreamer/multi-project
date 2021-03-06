package com.felixwc.publish.eden.blog.enums;

/**
 * in order to learn java!
 * created at 2022/6/17 01:20
 *
 * @author felixwc
 */
public enum CacheName {
    /* 永不过期的key */
    DURABLE_CACHE("DurableCache"),
    ONE_MINUTE_CACHE("M1Cache"),
    FIFTEEN_MINUTE_CACHE("M15Cache");
    private String cacheName;

    CacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCacheName() {
        return cacheName;
    }
}
