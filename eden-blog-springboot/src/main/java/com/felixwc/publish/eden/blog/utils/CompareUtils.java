package com.felixwc.publish.eden.blog.utils;

import java.util.Objects;

/**
 * in order to learn java!
 * created at 2022/6/17 00:47
 *
 * @author felixwc
 */
public class CompareUtils {

    /**
     * @param one     - 一个整数
     * @param another - 另外一个整数
     * @return boolean
     * @Author felixwc
     * @Description //TODO 比较两个整数
     * @Date 00:50 2022/6/17
     **/
    public static boolean compareTwoInt(int one, int another) {
        return one == another;
    }

    /**
     * @param one     - 一个整数
     * @param another - 另外一个整数
     * @return boolean
     * @Author felixwc
     * @Description //TODO 比较两个整数
     * @Date 00:50 2022/6/17
     **/
    public static boolean compareTwoInt(Integer one, Integer another) {
        if (Objects.isNull(one) || Objects.isNull(another)) return false;
        return one.intValue() == another.intValue();
    }

    /**
     * @param one     - 一个整数
     * @param another - 另外一个整数
     * @return boolean
     * @Author felixwc
     * @Description //TODO 比较两个整数
     * @Date 00:50 2022/6/17
     **/
    public static boolean compareTwoInt(Integer one, int another) {
        if(Objects.isNull(one)) return false;
        return one == another;
    }

    /**
     * @param one     - 一个整数
     * @param another - 另外一个整数
     * @return boolean
     * @Author felixwc
     * @Description //TODO 比较两个整数
     * @Date 00:50 2022/6/17
     **/
    public static boolean compareTwoInt(int one, Integer another) {
        if(Objects.isNull(another)) return false;
        return one == another;
    }
}
