package com.felixwc.publish.eden.blog.service.cloud;

import com.felixwc.publish.eden.blog.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * in order to learn java!
 * created at 2022/6/16 20:58
 * 跟邮件有关的服务
 *
 * @author felixwc
 */
@Slf4j
@Service
public class QQEmailServiceImpl implements EmailService {
    private final JavaMailSender sender;
    private final QQEmailServiceImpl qqEmailService;
    @Value("${spring.mail.username}")
    private String sendAdder;

    @Value("${spring.mail.prefix:验证码：}")
    private String mailPrefix;

    @Value("${spring.mail.suffix:请不要告知他人}")
    private String mailSuffix;

    @Autowired
    public QQEmailServiceImpl(JavaMailSender sender, @Lazy QQEmailServiceImpl qqEmailService) {
        this.sender = sender;
        this.qqEmailService = qqEmailService;
    }


    /**
     * @param emailAddress - 邮箱地址
     * @param codeLength   - 验证码长度
     * @return java.util.concurrent.Future<java.lang.String> 返回null 就是发送不成功
     * @return java.util.concurrent.Future<java.lang.String> 返回null 就是发送不成功
     * @Author felixwc
     * @Description //TODO 给邮箱发送验证码 异步方法
     * @Date 22:21 2022/6/16
     **/
    @Override
    @Async
    public Future<String> sentCodeByEmail(String emailAddress, int codeLength) {
        String result;
        synchronized (emailAddress.intern()) {
            result = qqEmailService.sentCodeByEmailUsingCache(emailAddress, codeLength);
        }
        return new AsyncResult<>(result);
    }

    /**
     * @param emailAddress - 邮件地址
     * @param codeLength   - 验证码长度
     * @return java.util.concurrent.Future<java.lang.String>
     * @Author felixwc
     * @Description //TODO 这个方法不是线程安全的，只是为了能够使用缓存
     * @Date 00:03 2022/6/17
     **/
    @Cacheable(value = "M15Cache", key = "#emailAddress",unless = "#result ==null")
    public String sentCodeByEmailUsingCache(String emailAddress, int codeLength) {
        synchronized (emailAddress.intern()) {
            String code;
            try {
                SimpleMailMessage mail = new SimpleMailMessage();
                mail.setFrom(sendAdder);
                mail.setTo(emailAddress);
                code = RandomUtils.generateCode(codeLength);
                log.info(code);
                mail.setText(mailPrefix + code + mailSuffix);
                sender.send(mail);
            } catch (MailException e) {
                code = null;
                e.printStackTrace();
            }
            return code;
        }
    }
}
