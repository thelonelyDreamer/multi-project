package com.felixwc.publish.eden.blog.service.cloud;

import com.felixwc.publish.eden.blog.enums.CacheName;
import com.felixwc.publish.eden.blog.utils.CompareUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootTest
class QQEmailServiceImplTest{
    public static long TIME_FIFTEEN_MINUTE = 1000*60*15;
    public static long DISCREPANCY=100;

    @Autowired
    private QQEmailServiceImpl qqEmailService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CacheManager cacheManager;
    @Value("${my.email:}")
    private String toEmailAddress;


    @Test
    void sentCodeByEmailTest() throws ExecutionException, InterruptedException {
        int codeLength=6;
        assert Objects.nonNull(toEmailAddress);
        Future<String> stringFuture1 = qqEmailService.sentCodeByEmail(toEmailAddress, codeLength);
        Future<String> stringFuture2 = qqEmailService.sentCodeByEmail(toEmailAddress, codeLength);
        String s1 = stringFuture1.get();
        String s2 = stringFuture2.get();
        assert Objects.nonNull(s1)&&(CompareUtils.compareTwoInt(codeLength,s1.length()));
        assert Objects.nonNull(s2)&&(CompareUtils.compareTwoInt(codeLength,s2.length()));
    }

    @Test
    void sentCodeByEmailUsingCacheTest() {
        assert Objects.nonNull(toEmailAddress);
        int codeLength=6;
        Cache m15Cache = cacheManager.getCache(CacheName.FIFTEEN_MINUTE_CACHE.getCacheName());
        assert Objects.nonNull(m15Cache);
        for (int i = 0; i < 10; i++) {
            m15Cache.evictIfPresent(toEmailAddress.intern());
            String code1 = qqEmailService.sentCodeByEmailUsingCache(toEmailAddress, codeLength);
            long end1 = System.currentTimeMillis();
            String code2 = qqEmailService.sentCodeByEmailUsingCache(toEmailAddress, codeLength);
            long end2 = System.currentTimeMillis();
            assert end2 - end1 >= TIME_FIFTEEN_MINUTE + DISCREPANCY || code1.equals(code2);
        }
    }
}