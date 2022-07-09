package com.felixwc.publish.eden.blog.service.security;

/**
 * in order to learn java!
 * created at 2022/6/18 00:22
 *
 * @author felixwc
 */
public interface LoginService {
    /**
     * @param username - 用户名
     * @param password - 密码
     * @return 令牌
     * @return java.lang.String
     * @author felixwc
     * @description //TODO 根据用户名和密码获取jwt令牌
     * @date 20:59 2022/7/4
     **/
    String obtainJwt(String username, String password);
}
