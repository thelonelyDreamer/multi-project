package com.felixwc.publish.eden.blog.utils;

/**
 * in order to learn java!
 * created at 2022/6/17 00:47
 *
 * @author felixwc
 */
public class CompareUtils {

    /**
     * @param one
     * @param another
     * @return boolean
     * @Author felixwc
     * @Description //TODO 比较两个整数
     * @Date 00:50 2022/6/17
     **/
    public static boolean compareTwoInt(int one, int another) {
        return one == another;
    }

    /**
     * @param one
     * @param another
     * @return boolean
     * @Author felixwc
     * @Description //TODO 比较两个整数
     * @Date 00:50 2022/6/17
     **/
    public static boolean compareTwoInt(Integer one, Integer another) {
        return one.intValue() == another.intValue();
    }

    /**
     * @param one
     * @param another
     * @return boolean
     * @Author felixwc
     * @Description //TODO 比较两个整数
     * @Date 00:50 2022/6/17
     **/
    public static boolean compareTwoInt(Integer one, int another) {
        return one.intValue() == another;
    }

    /**
     * @param one
     * @param another
     * @return boolean
     * @Author felixwc
     * @Description //TODO 比较两个整数
     * @Date 00:50 2022/6/17
     **/
    public static boolean compareTwoInt(int one, Integer another) {
        return one == another.intValue();
    }
}
