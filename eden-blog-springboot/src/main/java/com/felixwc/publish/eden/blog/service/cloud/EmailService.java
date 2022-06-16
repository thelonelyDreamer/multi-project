package com.felixwc.publish.eden.blog.service.cloud;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

/**
 * in order to learn java!
 * created at 2022/6/16 21:17
 *
 * @author felixwc
 */
public interface EmailService {

    @Async
    Future<String> sentCodeByEmail(String emailAddress, int codeLength);
}
