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

    /**
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult
     * @Author felixwc
     * @Description //TODO 返回一个通用成功的状态
     * @Date 20:44 2022/6/16
     **/
    public static CommonResult defaultSuccess() {
        return new CommonResult(CommonState.SUCCESS.getCode(), CommonState.SUCCESS.getDescription());
    }

    /**
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult
     * @Author felixwc
     * @Description //TODO 返回一个通用失败的状态
     * @Date 20:45 2022/6/16
     **/
    public static CommonResult defaultFail() {
        return new CommonResult(CommonState.FAIL.getCode(), CommonState.FAIL.getDescription());
    }

    /**
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder<T>
     * @Author felixwc
     * @Description //TODO 获取构建者
     * @Date 20:42 2022/6/16
     **/
    public CommonResultBuilder<T> startBuilder() {
        this.commonResult = new CommonResult<T>();
        return this;
    }

    /**
     * @return com.felixwc.publish.eden.blog.pojo.vo.CommonResult<T>
     * @Author felixwc
     * @Description //TODO 返回构建的对象
     * @Date 20:42 2022/6/16
     **/
    public CommonResult<T> build() {
        return this.commonResult;
    }

}
