package com.felixwc.publish.eden.blog.controller.common;

import com.felixwc.publish.eden.blog.pojo.vo.CommonResult;
import com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder;
import com.felixwc.publish.eden.blog.pojo.vo.state.EmailState;
import com.felixwc.publish.eden.blog.service.cloud.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * in order to learn java!
 * created at 2022/6/15 16:34
 *
 * @author felixwc
 */
@RestController
@Api
@RequestMapping("/common/email")
@Slf4j
public class EmailController {
    private static final int CODE_LENGTH = 6;
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/code")
    @ApiOperation(value = "用邮箱获取验证码")
    @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "form")
    public CommonResult<String> obtainEmailCode(@RequestParam() String email) throws AddressException {
        log.info("start to validate email address");
        // 如果邮箱不合法
        new InternetAddress(email).validate();
        log.info("email address is valid");
        // 如果邮箱合法
        emailService.sentCodeByEmail(email, CODE_LENGTH);
        //返回结果
        CommonResultBuilder<String> resultBuilder = new CommonResultBuilder<>();
        resultBuilder.setCode(EmailState.SUCCESS.getCode()).setMessage(EmailState.SUCCESS.getDescription());
        return resultBuilder.build();
    }


    @ExceptionHandler({AddressException.class})
    public CommonResult addressExceptionHandle() {
        return CommonResultBuilder.defaultFail(EmailState.ERROR_EMAIL.getCode(), EmailState.ERROR_EMAIL.getDescription());
    }
}
