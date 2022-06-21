package com.felixwc.publish.eden.blog.controller.exhandler;

import com.felixwc.publish.eden.blog.execption.security.UserInfoErrorException;
import com.felixwc.publish.eden.blog.pojo.vo.CommonResult;
import com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder;
import com.felixwc.publish.eden.blog.pojo.vo.state.SecurityState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * in order to learn java!
 * created at 2022/6/19 20:57
 *
 * @author felixwc
 */
@RestControllerAdvice
@Slf4j
public class SecurityControllerAdvice {

    /**
     * @param e - 用户信息错误异常
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult
     * @author felixwc
     * @description //TODO 用户名或者密码错误
     * @date 21:28 2022/6/19
     **/
    @ExceptionHandler({UserInfoErrorException.class, UsernameNotFoundException.class})
    public CommonResult userInfoErrorExceptionHandler(Exception e) {
        log.info(e.getMessage());
        return CommonResultBuilder.defaultFail(
                SecurityState.USER_INFO_ERROR.getCode(),
                SecurityState.USER_INFO_ERROR.getDescription()
        );
    }

}
