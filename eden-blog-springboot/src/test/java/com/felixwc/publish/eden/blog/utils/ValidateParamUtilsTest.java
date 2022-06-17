package com.felixwc.publish.eden.blog.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateParamUtilsTest {

    @Test
    public void phoneNumIsCorrectTest(){
        assert ValidateParamUtils.phoneNumIsCorrect("1")==false;
        assert ValidateParamUtils.phoneNumIsCorrect("18401585724")==true;
    }

    @Test
    void phoneNumIsCorrect() {
    }

    @Test
    void emailAddressIsCorrect() {
    }

    @Test
    void emailIsCorrect() {
        assert  !ValidateParamUtils.emailIsCorrect("123");
    }
}