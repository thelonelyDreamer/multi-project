package com.felixwc.publish.eden.blog.utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * in order to learn java!
 * created at 2022/6/16 10:38
 * 验证参数的合法性
 *
 * @author felixwc
 */
public class ValidateParamUtils {
    public static final Pattern phoneNumPattern;
    public static final Pattern emailAddressPattern;

    static {
        phoneNumPattern = Pattern.compile("^((13[0-9])|(14[05679])|(15([0-3,5-9]))|(16[2567])|(17[01235678])|(18[0-9])|(19[135689]))\\d{8}$");
        emailAddressPattern = Pattern.compile("[a-zA-Z0-9_]+@([a-zA-Z0-9]+\\.)+[a-zA-Z0-9]+");
    }

    /**
     * @param phone - 手机号
     * @return boolean if phone is correct return true,otherwise return false;
     * @Author felixwc
     * @Description //TODO 验证手机号是否正确 验证大陆手机号
     * @Date 10:44 2022/6/16
     **/
    public static boolean phoneNumIsCorrect(String phone) {
        Matcher matcher = phoneNumPattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * @param email
     * @return boolean
     * @author felixwc
     * @description //TODO 只是简单的判别一下
     * @date 14:37 2022/6/17
     **/
    public static boolean emailAddressIsCorrect(String email) {
        Matcher matcher = emailAddressPattern.matcher(email);
        return matcher.matches();
    }

    public static boolean emailIsCorrect(String email) {
        boolean result;
        try {
            InternetAddress internetAddress = new InternetAddress("email");
            internetAddress.validate();
            result = true;
        } catch (AddressException e) {
            result = false;
        }
        return result;
    }
}
