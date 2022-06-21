package com.felixwc.publish.eden.blog.service.security.impl;

import com.felixwc.publish.eden.blog.config.properties.JWTProperties;
import com.felixwc.publish.eden.blog.pojo.security.LoginUser;
import com.felixwc.publish.eden.blog.service.security.LoginService;
import com.felixwc.publish.eden.blog.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * in order to learn java!
 * created at 2022/6/18 15:37
 *
 * @author felixwc
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;
    private final JWTProperties jwtProperties;
    private final Cache durableCache;


    public LoginServiceImpl(AuthenticationManager authenticationManager, JWTProperties jwtProperties, Cache durableCache) {
        this.authenticationManager = authenticationManager;
        this.jwtProperties = jwtProperties;
        this.durableCache = durableCache;
    }

    @Override
    public String obtainJwt(String username, String password) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 业务处理完成，开始返回结果
        if (Objects.isNull(authenticate)) {
            log.warn("fail to authenticate");
            return null;
        }
        log.debug("用户验证成功");
        Object principal = authenticate.getPrincipal();
        String token = null;
        if (principal instanceof LoginUser) {
            LoginUser loginUser = (LoginUser) principal;
            String loginUserUsername = loginUser.getUsername();
            durableCache.put(jwtProperties.getUsername()+ "_" + loginUserUsername, loginUser);
            HashMap<String, String> map = new HashMap<>();
            map.put(jwtProperties.getUsername(), loginUserUsername);
            token = JWTUtils.createToken(map, jwtProperties.getSecret(), jwtProperties.getTokenRemainTime());
        }

        return token;
    }
}
