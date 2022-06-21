package com.felixwc.publish.eden.blog.controller.common;

import com.felixwc.publish.eden.blog.pojo.vo.CommonResult;
import com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder;
import com.felixwc.publish.eden.blog.pojo.vo.state.SMSState;
import com.felixwc.publish.eden.blog.service.cloud.SmsService;
import com.felixwc.publish.eden.blog.utils.StringsUtils;
import com.felixwc.publish.eden.blog.utils.ValidateParamUtils;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.Objects;

/**
 * in order to learn java!
 * created at 2022/6/15 16:32
 *
 * @author felixwc
 */
@RestController
@RequestMapping("/common/sms")
@Slf4j
@Api
public class SmsController {
    private final static int codeLength = 6;
    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/code")
    @PermitAll
    @ApiOperation(value = "获取短信验证码")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "number",value = "手机号码",required = true,paramType = "form")
    )
    public CommonResult<String> obtainValidatedCode(
            @RequestParam("number") String phoneNumber
    ) {
        // 1. 验证参数的合法性，并记录
        boolean phoneNumFlag = ValidateParamUtils.phoneNumIsCorrect(phoneNumber);
        if (!phoneNumFlag) {
            log.info("error phone");
            return CommonResultBuilder.defaultFail(SMSState.ERROR_NUMBER.getCode(),SMSState.ERROR_NUMBER.getDescription());
        }
        // 2. 调用业务方法
        String code = smsService.sendValidatedCode(phoneNumber, codeLength);

        // 3. 根据业务方法返回结果
        CommonResultBuilder<String> resultBuilder = new CommonResultBuilder<>();
        // 如果结果未发送成功
        if (Objects.isNull(code)) {
            log.info("phone is validated but fail to send");
            resultBuilder.setCode(SMSState.FAIL.getCode())
                    .setMessage(SMSState.FAIL.getDescription());
        } else if (StringsUtils.stringIsEmpty(code)) {
            // 已经发送
            log.info("send code already. the code is " +code);
            resultBuilder.setCode(SMSState.SEND_ALREADY.getCode())
                    .setMessage(SMSState.SEND_ALREADY.getDescription());
        } else {
            log.info("send code successfully ");
            resultBuilder.setCode(SMSState.SUCCESS.getCode())
                    .setCode(SMSState.SUCCESS.getDescription());
        }
        // 这里不用session缓存 如果要设置过期时间，可以采用code 和时间同时存储

        return resultBuilder.build();
    }
}
