package com.felixwc.publish.eden.blog.pojo.security;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

/**
 * in order to learn java!
 * created at 2022/6/10 22:27
 *
 * @author felixwc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUser {
    /* 用户id */
    private Long id;
    /* 用户姓名 */
    private String username;
    /* 用户密码 */
    private String password;
    /* 用户角色 */
    private Set<SecurityRole> roles;
    /* 用户权利 */
    private Set<SecurityRight> rights;

    /* 每个表的标记 */
    private Boolean deletedFlag;
    private Long version;
    private Date createdTime;
    private String createdUser;
    private Date updatingTime;
    private String updatingUser;
}
