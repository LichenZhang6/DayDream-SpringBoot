package com.daydream.platform.config;

import com.daydream.platform.entity.User;
import com.daydream.platform.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("Do Get Authorization Info");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("Do Get Authentication Info");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getByName(token.getUsername());
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo("", user.getPassword(), "");
    }
}
