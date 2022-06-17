package com.felixwc.publish.eden.blog.utils;

import org.junit.jupiter.api.Test;

class CompareUtilsTest {

    @Test
    void compareTwoInt() {
        assert CompareUtils.compareTwoInt(1, 1);
        assert !CompareUtils.compareTwoInt(1, 21);
    }

    @Test
    void testCompareTwoInt() {
        assert CompareUtils.compareTwoInt(new Integer(1234), new Integer(1234));
        assert !CompareUtils.compareTwoInt(new Integer(1234), new Integer(1235));
        assert !CompareUtils.compareTwoInt(null,null);
        System.out.println(null==null);
        assert !CompareUtils.compareTwoInt(null,new Integer(1));
        assert !CompareUtils.compareTwoInt(new Integer(1),null);
    }

    @Test
    void testCompareTwoInt1() {
        //略
        assert CompareUtils.compareTwoInt(new Integer(1234),1234);
        assert !CompareUtils.compareTwoInt(null,1234);
    }

    @Test
    void testCompareTwoInt2() {
        assert CompareUtils.compareTwoInt(1234,new Integer(1234));
        assert !CompareUtils.compareTwoInt(1234,null);
    }
}