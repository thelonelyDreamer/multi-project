package com.felixwc.publish.eden.blog.controller.blog;

import com.felixwc.publish.eden.blog.pojo.vo.CommonResult;
import com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * in order to learn java!
 * created at 2022/7/5 09:38
 *
 * @author felixwc
 */
@RestController
@RequestMapping("/blog/tag")
@Api
public class TagController {
    @GetMapping("/all")
    @ApiOperation("")
    public CommonResult<Set<String>> getAllTags(){
        HashSet<String> tags = new HashSet<>();
        CommonResultBuilder<Set<String>> resultBuilder = CommonResultBuilder.startBuilder();
        resultBuilder.setData(tags);
        return resultBuilder.build();
    }
}
