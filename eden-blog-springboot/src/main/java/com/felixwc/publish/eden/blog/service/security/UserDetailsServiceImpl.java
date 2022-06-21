package com.felixwc.publish.eden.blog.service.security;

import com.felixwc.publish.eden.blog.execption.security.UserInfoErrorException;
import com.felixwc.publish.eden.blog.mapper.security.SecurityUserMapper;
import com.felixwc.publish.eden.blog.pojo.security.LoginUser;
import com.felixwc.publish.eden.blog.pojo.security.SecurityRight;
import com.felixwc.publish.eden.blog.pojo.security.SecurityRole;
import com.felixwc.publish.eden.blog.pojo.security.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * in order to learn java!
 * created at 2022/6/18 16:08
 *
 * @author felixwc
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SecurityUserMapper securityUserMapper;

    public UserDetailsServiceImpl(SecurityUserMapper securityUserMapper) {
        this.securityUserMapper = securityUserMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser securityUser = securityUserMapper.obtainSecurityUserByNameWithRole(username);
        if(Objects.isNull(securityUser)){
            log.info("user not exit or user's info is wrong.");
            throw  new UserInfoErrorException("user not exit or user's info is wrong.");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(securityUser.getUsername());
        loginUser.setPassword(securityUser.getPassword());
        HashSet<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<SecurityRole> roles = securityUser.getRoles();
        if(Objects.nonNull(roles)){
            for (SecurityRole role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
            }
        }
        Set<SecurityRight> rights = securityUser.getRights();
        if(Objects.nonNull(rights)){
            for (SecurityRight right : rights) {
                grantedAuthorities.add(new SimpleGrantedAuthority(right.getName()));
            }
        }
        loginUser.setAuthorities(grantedAuthorities);
        return loginUser;
    }
}
