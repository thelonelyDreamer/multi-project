package com.felixwc.publish.eden.blog.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * in order to learn java!
 * created at 2022/6/16 21:57
 *
 * @author felixwc
 */
public class RandomUtils {
    // 为生成验证码准备数组
    private static final String codeString = "0123456789qwertyuiopasdfghjklzxcvbnmZXCVBNMASDFGHJKLQWERTYUIOP";


    /**
     * @param codeLength 要产生字符串的长度
     * @return java.lang.String
     * @author felixwc
     * @description //TODO 产生随机字符串 这个方法不会返回null值
     * @date 22:07 2022/6/16
     **/
    public static String generateCode(int codeLength) {
        if(codeLength<=0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        int length = codeString.length();
        for (int i = 0; i < codeLength; i++) {
            int index = ThreadLocalRandom.current().nextInt(length);
            stringBuilder.append(codeString.charAt(index));
        }
        return stringBuilder.toString();
    }
}
