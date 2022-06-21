package com.felixwc.publish.eden.blog.mapper.security;

import com.felixwc.publish.eden.blog.pojo.security.SecurityUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * in order to learn java!
 * created at 2022/6/18 19:45
 *
 * @author felixwc
 */
@Mapper
public interface SecurityUserMapper {
    /**
     * @param username 用户命名 上面有唯一索引
     * @return com.felixwc.publish.eden.blog.pojo.security.SecurityUser
     * @author felixwc
     * @description //TODO 返回用户id 名字 以及密码
     * @date 22:40 2022/6/18
     **/
    SecurityUser obtainSecurityUserByName(@Param("username") String username);

    /**
     * @param
     * @param username
     * @return com.felixwc.publish.eden.blog.pojo.security.SecurityUser
     * @description //TODO 返回用户的id 名字 密码 角色
     * @date 22:42 2022/6/18
     **/
    SecurityUser obtainSecurityUserByNameWithRole(String username);
}
