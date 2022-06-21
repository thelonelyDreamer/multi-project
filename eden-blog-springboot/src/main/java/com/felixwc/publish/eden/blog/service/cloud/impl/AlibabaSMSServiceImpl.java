package com.felixwc.publish.eden.blog.service.cloud.impl;

import com.alibaba.alicloud.sms.ISmsService;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.felixwc.publish.eden.blog.service.cloud.SmsService;
import com.felixwc.publish.eden.blog.utils.RandomUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * in order to learn java!
 * created at 2022/6/15 14:55
 * 短信发送功能
 * <p>
 * 这个类还存在的问题：模板参数是硬编码，可以调整，
 *
 * @author felixwc
 */
@Service
@Getter
@Setter
@Slf4j
public class AlibabaSMSServiceImpl implements SmsService {

    /**
     * 阿里云的短信服务
     **/
    private final ISmsService smsService;

    /**
     * 短信签名
     **/
    @Value("${spring.cloud.alicloud.sms.sign-name:}")
    private String signName;
    /**
     * 模板代号
     **/
    @Value("${spring.cloud.alicloud.sms.template-code:}")
    private String templateCode;

    public AlibabaSMSServiceImpl(ISmsService smsService) {
        this.smsService = smsService;
    }

    @Autowired
    @Lazy
    private AlibabaSMSServiceImpl alibabaSMSServiceImpl;

    @Override
    public String sendValidatedCode(String number, int codeLength) {
        String code = RandomUtils.generateCode(codeLength);

        String anotherCode = null;
        synchronized (number) {
            anotherCode = alibabaSMSServiceImpl.sendCodeToOneNumber(code, number);
        }
        //  如果发送失败，返回null
        // 如果已经发送，返回""
        if (!code.equals(anotherCode)) {
            anotherCode = "";
        }

        return anotherCode;
    }


    /**
     * @param code   验证码
     * @param number 手机号码
     * @return com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse
     * @Author felixwc
     * @Description //TODO 给一个号码发送验证码
     * @Date 16:16 2022/6/15
     **/
    @Cacheable(value = "M1Cache", key = "#number", unless = "null == #result")
    public String sendCodeToOneNumber(String code, String number) {
        log.info(code + number);
        SendSmsRequest request = new SendSmsRequest();
        // Required:the mobile number
        request.setPhoneNumbers(number);
        // Required:SMS-SignName-could be found in sms console
        request.setSignName(signName);
        // Required:Template-could be found in sms console
        request.setTemplateCode(templateCode);
        // Required:The param of sms template.For exmaple, if the template is "Hello,your verification code is ${code}". The param should be like following value
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        try {
            smsService.sendSmsRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
            code = null;
        }
        return code;
    }

}
