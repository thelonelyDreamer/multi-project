package com.felixwc.publish.eden.blog.pojo.vo;

import com.felixwc.publish.eden.blog.pojo.vo.state.CommonState;

/**
 * in order to learn java!
 * created at 2022/6/16 14:19
 *
 * @author felixwc
 */

// 系统返回结果的的构建者
public class CommonResultBuilder<T> {
    private CommonResult<T> commonResult;


    public static CommonResult defaultSuccess(){
        return new CommonResult(CommonState.SUCCESS.getCode(),CommonState.SUCCESS.getDescription());
    }

    public static CommonResult defaultFail(){
        return new CommonResult(CommonState.FAIL.getCode(),CommonState.FAIL.getDescription());
    }

    public CommonResultBuilder<T>  startBuilder(){
        this.commonResult=new CommonResult<T>();
        return this;
    }
    public CommonResult<T> build(){
        return this.commonResult;
    }

}
