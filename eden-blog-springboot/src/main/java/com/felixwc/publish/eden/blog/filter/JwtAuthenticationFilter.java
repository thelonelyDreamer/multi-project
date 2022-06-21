package com.felixwc.publish.eden.blog.filter;

import com.felixwc.publish.eden.blog.config.properties.JWTProperties;
import com.felixwc.publish.eden.blog.execption.security.TokenException;
import com.felixwc.publish.eden.blog.pojo.security.LoginUser;
import com.felixwc.publish.eden.blog.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * in order to learn java!
 * created at 2022/6/18 00:15
 *
 * @author felixwc
 */
@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JWTProperties properties;
    private final Cache durableCache;

    public JwtAuthenticationFilter(JWTProperties properties, Cache durableCache) {
        this.properties = properties;
        this.durableCache = durableCache;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 判断token的合法性
        String token = request.getHeader(properties.getHead());
        if (Objects.isNull(token) || StringUtils.isEmpty(token)) {
            filterChain.doFilter(request, response);
            if(log.isDebugEnabled()){
                log.debug("there is no token in the heads.");
            }
            return;
        }
        log.debug("there is has a token in the heads.");
        log.debug(token);
        String[] tokens = token.split(" ");
        if (tokens.length != 2 || tokens[0].equalsIgnoreCase(properties.getPrefix())) {
            throw new TokenException("the format of the token is invalid.");
        }
        Claims claims = JWTUtils.parseToken(tokens[1], properties.getSecret());
        if (Objects.isNull(claims)) {
            throw new TokenException("the token is invalid");
        }
        String username = claims.get(properties.getUsername(), String.class);
        LoginUser loginUser = durableCache.get(properties.getUsername() + "_" + username, LoginUser.class);

        //如果缓存中没有
        if(Objects.isNull(loginUser)){
            throw new TokenException("the token is invalid");
        }
        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword(),
                        loginUser.getAuthorities()
                ));
        log.info("token is valid");
        filterChain.doFilter(request, response);
    }
}
