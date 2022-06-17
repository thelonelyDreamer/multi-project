package com.felixwc.publish.eden.blog.controller.exhandler;

import com.felixwc.publish.eden.blog.pojo.vo.CommonResult;
import com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * in order to learn java!
 * created at 2022/6/17 17:52
 *
 * @author felixwc
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerAdvice {
    @ExceptionHandler({Throwable.class})
    public CommonResult<String> throwable(Throwable throwable){
        System.out.println("throwable");
        return CommonResultBuilder.defaultFail();
    }
}
