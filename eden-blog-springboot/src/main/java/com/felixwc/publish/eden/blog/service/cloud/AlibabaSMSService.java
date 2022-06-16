package com.felixwc.publish.eden.blog.service.cloud;

import com.alibaba.alicloud.sms.ISmsService;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * in order to learn java!
 * created at 2022/6/15 14:55
 * 短信发送功能
 *
 * 这个类还存在的问题：模板参数是硬编码，可以调整，
 * @author felixwc
 */
@Service
@Getter
@Setter
@Slf4j
public class AlibabaSMSService {

    // 为生成验证码准备数组
    private static final String codeString="0123456789qwertyuiopasdfghjklzxcvbnmZXCVBNMASDFGHJKLQWERTYUIOP";

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

    public AlibabaSMSService(ISmsService smsService) {
        this.smsService = smsService;
    }

    @Autowired
    @Lazy
    private AlibabaSMSService alibabaSMSService;
    @Cacheable(value = "M1Cache",key = "#number")
    public String sendValidatedCode(String number,int codeLength){
        String code=generateCode(codeLength);
        alibabaSMSService.sendCodeToOneNumber(code,number);
        return code;
    }


    /**
     * @param code 验证码
     * @param number 手机号码
     * @return com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse
     * @Author felixwc
     * @Description //TODO 给一个号码发送验证码
     * @Date 16:16 2022/6/15
     **/
    private SendSmsResponse sendCodeToOneNumber(String code, String number) {
        log.info(code+number);
        SendSmsRequest request = new SendSmsRequest();
        // Required:the mobile number
        request.setPhoneNumbers(number);
        // Required:SMS-SignName-could be found in sms console
        request.setSignName(signName);
        // Required:Template-could be found in sms console
        request.setTemplateCode(templateCode);
        // Required:The param of sms template.For exmaple, if the template is "Hello,your verification code is ${code}". The param should be like following value
        request.setTemplateParam("{\"code\":\"" + code + "\"}");
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = smsService.sendSmsRequest(request);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
        return sendSmsResponse;
    }
    private String generateCode(int codeLength){
        StringBuilder stringBuilder = new StringBuilder();
        int length = codeString.length();
        for (int i=0;i<codeLength;i++) {
            int index = ThreadLocalRandom.current().nextInt(length);
            stringBuilder.append(codeString.charAt(index));
        }
        return stringBuilder.toString();
    }
}
