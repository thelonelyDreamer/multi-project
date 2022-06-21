package com.felixwc.publish.eden.blog.service.security;

/**
 * in order to learn java!
 * created at 2022/6/18 00:22
 *
 * @author felixwc
 */
public interface LoginService {
    String obtainJwt(String username,String password);
}
