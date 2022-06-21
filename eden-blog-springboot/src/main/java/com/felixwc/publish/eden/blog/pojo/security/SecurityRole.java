package com.felixwc.publish.eden.blog.pojo.security;

import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * in order to learn java!
 * created at 2022/6/10 22:27
 * 用户角色表
 * @author felixwc
 */
@Data
public class SecurityRole {
    /* 角色id */
    private Integer id;
    /* 角色名字 */
    private String name;
    /* 角色描述 */
    private String desp;
    /* 角色权利 */
    private Set<SecurityRight> securityRights;
    /* 角色所对应的用户 */
    private Set<SecurityUser> securityUsers;

    private Boolean deletedFlag;
    private Long version;
    private Date createdTime;
    private String createdUser;
    private Date updatingTime;
    private String updatingUser;

}
