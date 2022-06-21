package com.felixwc.publish.eden.blog.controller.common;

import com.felixwc.publish.eden.blog.config.properties.JWTProperties;
import com.felixwc.publish.eden.blog.execption.security.UserInfoErrorException;
import com.felixwc.publish.eden.blog.pojo.vo.CommonResult;
import com.felixwc.publish.eden.blog.pojo.vo.CommonResultBuilder;
import com.felixwc.publish.eden.blog.pojo.vo.state.SecurityState;
import com.felixwc.publish.eden.blog.service.security.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * in order to learn java!
 * created at 2022/6/17 20:41
 *
 * @author felixwc
 */
@RestController
@Slf4j
@RequestMapping("/common/jwt")
public class JWTUserController {

    private final LoginService service;
    private final JWTProperties properties;

    public JWTUserController(LoginService service, JWTProperties properties) {
        this.service = service;
        this.properties = properties;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @PermitAll
    public CommonResult<Map<String,String>> login(String username, String password) {
        // 1. 参数解密，校验
        log.debug("username:"+username+"password:" + password);
        // 2. 调用服务
        String token = service.obtainJwt(username, password);
        // 3. 封装结果
        CommonResultBuilder<Map<String, String>> resultBuilder = new CommonResultBuilder<>();
        if (Objects.nonNull(token)) {
            HashMap<String, String> map = new HashMap<>(8);
            map.put("head",properties.getHead());
            map.put("prefix",properties.getPrefix());
            map.put("token",token);
            resultBuilder.setData(map)
                    .setCode(SecurityState.JWT_SUCCESS.getCode())
                    .setMessage(SecurityState.JWT_SUCCESS.getDescription());
        } else {
            resultBuilder.setCode(SecurityState.JWT_FAIL.getCode())
                    .setMessage(SecurityState.JWT_FAIL.getDescription());
        }
        return resultBuilder.build();
    }

    @ExceptionHandler({UserInfoErrorException.class})
    public CommonResult dealUserInfoErrorException(Exception e){
        e.printStackTrace();
        return CommonResultBuilder.defaultFail(SecurityState.JWT_FAIL.getCode(),e.getMessage());
    }
}
