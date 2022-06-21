package com.felixwc.publish.eden.blog.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * in order to learn java!
 * created at 2022/6/19 14:28
 *
 * @author felixwc
 */
@Component
@Order(Integer.MIN_VALUE)
@Slf4j
public class SecurityExceptionFilter extends OncePerRequestFilter {

    private final HandlerExceptionResolver resolver;

    public SecurityExceptionFilter(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            log.debug(this.getClass().getName()+" enter");
            filterChain.doFilter(request, response);
            log.debug(this.getClass().getName()+" leave");
        } catch (Exception e) {
            log.error("Spring Security Filter Chain Exception:", e);
            resolver.resolveException(request, response, null, e);
        }
    }
}
