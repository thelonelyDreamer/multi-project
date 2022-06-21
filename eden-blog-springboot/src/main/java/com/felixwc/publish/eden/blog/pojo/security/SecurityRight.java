package com.felixwc.publish.eden.blog.pojo.security;

import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * in order to learn java!
 * created at 2022/6/10 22:27
 *
 * @author felixwc
 */
@Data
public class SecurityRight {
    /* 权利id */
    private Long id;
    /* 权利姓名 */
    private String name;
    /* 权利描述 */
    private String desp;
    /* 拥有该权利的角色 */
    private Set<SecurityRole> securityRoles;
    /* 拥有该权利的用户 */
    private Set<SecurityUser> securityUsers;

    /* 每个表的六个字段 */
    private Boolean deletedFlag;
    private Long version;
    private Date createdTime;
    private String createdUser;
    private Date updatingTime;
    private String updatingUser;
}
