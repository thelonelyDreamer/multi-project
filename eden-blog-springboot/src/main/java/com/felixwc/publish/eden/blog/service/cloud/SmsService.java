package com.felixwc.publish.eden.blog.service.cloud;

/**
 * in order to learn java!
 * created at 2022/6/16 21:14
 *
 * @author felixwc
 */
public interface SmsService {

    String sendValidatedCode(String number,int codeLength);
}
