package com.felixwc.publish.eden.blog.utils;

import java.util.List;

/**
 * in order to learn java!
 * created at 2022/6/17 11:34
 *
 * @author felixwc
 */
public class StringsUtils {

    public static boolean stringIsEmpty(String s){
        return 0==s.length();
    }

    public static boolean stringIsNull(String s){
        return null==s;
    }

    public static String list2StringWithChar(List<String> strings, String separator) {
        if(0==strings.size()) return  null;
        if(1==strings.size()) return strings.get(0);
        StringBuilder stringBuilder = new StringBuilder(strings.get(0));
        for(int i=1;i<strings.size();i++){
            stringBuilder.append(separator).append(strings.get(i));
        }
        return stringBuilder.toString();
    }
}
