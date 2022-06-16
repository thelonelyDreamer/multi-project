package com.felixwc.publish.eden.blog.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateParamUtilsTest {

    @Test
    public void phoneNumIsCorrectTest(){
        assert ValidateParamUtils.phoneNumIsCorrect("83123456789")==false;
        assert ValidateParamUtils.phoneNumIsCorrect("18401585724")==true;
    }

}