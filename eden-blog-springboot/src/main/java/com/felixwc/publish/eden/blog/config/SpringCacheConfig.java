package com.felixwc.publish.eden.blog.config;

import com.felixwc.publish.eden.blog.enums.CacheName;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * in order to learn java!
 * created at 2022/6/19 11:50
 * 把常用的cache注入到spring容器中,这个应是批量注入的，目前先不管，先手动注入
 *
 * @author felixwc
 */
@Configuration
public class SpringCacheConfig {
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(){
        return new EhCacheCacheManager();
    }

    /**
     * @return org.springframework.cache.Cache
     * @author felixwc
     * @description //TODO 这个cache里面的key不会过期
     * @date 12:56 2022/6/19
     **/
    @Bean("durableCache")
    public Cache durableCache(EhCacheCacheManager cacheManager) {
        return cacheManager.getCache(CacheName.DURABLE_CACHE.getCacheName());
    }

}
