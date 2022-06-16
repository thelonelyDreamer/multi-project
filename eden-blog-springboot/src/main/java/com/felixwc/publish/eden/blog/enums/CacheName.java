package com.felixwc.publish.eden.blog.enums;

/**
 * in order to learn java!
 * created at 2022/6/17 01:20
 *
 * @author felixwc
 */
public enum CacheName {
    ONE_MINUTE_CACHE("M1Cache");
    private String cacheName;

    CacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCacheName() {
        return cacheName;
    }
}
