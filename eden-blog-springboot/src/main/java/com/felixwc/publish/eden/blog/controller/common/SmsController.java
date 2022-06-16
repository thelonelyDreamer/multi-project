package com.felixwc.publish.eden.blog.controller.common;

import com.felixwc.publish.eden.blog.service.cloud.AlibabaSMSService;
import com.felixwc.publish.eden.blog.utils.ValidateParamUtils;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * in order to learn java!
 * created at 2022/6/15 16:32
 *
 * @author felixwc
 */
@RestController
@RequestMapping("/common/sms")
@Logger
public class SmsController {
    private  final static int codeLength=6;
    @Autowired
    private AlibabaSMSService alibabaSMSService;

    @PostMapping("code")
    public String obtainValidatedCode(@RequestParam("number") String phoneNumber){
        // 1. 验证参数的合法性，并记录
        boolean phoneNumFlag = ValidateParamUtils.phoneNumIsCorrect(phoneNumber);
        // 2. 调用业务方法
        String code = alibabaSMSService.sendValidatedCode(phoneNumber, codeLength);
        // 3. 根据业务方法返回结果
        return code;
    }
}
