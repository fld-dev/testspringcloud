package com.test.testspringcloudproduct.realms;



import com.test.testspringcloudproduct.mapper.UserMapper;
import com.test.testspringcloudproduct.po.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;


    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("MD5");
        hashedCredentialsMatcher.setHashIterations(1);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }

    //用于用户权限的授取和封装
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();//获取前端表单传过来的用户名
        Set<String> roles = new HashSet<>();//两种授权方式：1.赋予用户角色，多个角色存储在set数组中
        Set<String> permissions=new HashSet<>();//两种授权方式：2.赋予用户权限标识，多个权限标识存储在set数组中

        if ("admin".equals(username)) {
            roles.add("admin");//给用户名为admin的用户赋予admin角色标识.在控制层的接口上通过@RequireRoles("admin")做角色方面的权限控制
            permissions.add("user:list");//给用户名为admin的用户赋予[user:list]权限标识.在控制层的接口上通过@RequiredPermission("user:list")做权限标识方面的权限控制
        }

        //封装权限信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);//将用户授予的角色权限set进权限信息
        simpleAuthorizationInfo.setStringPermissions(permissions);//将用户授予的权限标识信息set进权限信息
        return simpleAuthorizationInfo;
    }

    //用户登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //根据AuthenticationToken token,获取通过表单传过来的用户名
        String username = (String)token.getPrincipal();
        //根据用户名从数据库查询数据
        SysUser userByUsername = userMapper.findUserByUsername(username);
        //判断用户的身份
        if (userByUsername==null)throw new UnknownAccountException("用户名或密码不正确");
        //使用API:SimpleAuthenticationTokenInfo 对传入的参数进行验证
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userByUsername.getUsername(),userByUsername.getPassword(),"MyRealm");
        return info;
    }
}
