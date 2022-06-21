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
    private static String logPrefix="\n    ";
    @ExceptionHandler({Throwable.class})
    public CommonResult<String> throwableHandler(Throwable throwable){
        log.error("unknown error.");
        return CommonResultBuilder.defaultFail();
    }

    @ExceptionHandler(Exception.class)
    public CommonResult<String> exceptionHandler(Exception e) {
        int length = e.getStackTrace().length>15?15:e.getStackTrace().length;
        StringBuilder stringBuilder = new StringBuilder(e.getMessage());
        stringBuilder.append(logPrefix).append(e.getClass());
        for (int i = 0; i < length; i++) {
            stringBuilder.append(logPrefix).append(e.getStackTrace()[i]);
        }
        log.warn(stringBuilder.toString());
        return CommonResultBuilder.defaultFail();
    }

}
