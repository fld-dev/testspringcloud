package com.test.testspringcloudproduct.config;


import com.test.testspringcloudproduct.realms.MyRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Configuration//用来声明替换xml的类，常与@Bean搭配使用
public class ShiroConfig {

    //注入自定义的realm
    @Bean
    public MyRealm myAuthRealm(){
        MyRealm myRealm = new MyRealm();
        log.info("=====myRealm注入完成");
        return myRealm;
    }

    //注入安全管理器对象
    @Bean
    public DefaultWebSecurityManager securityManager(){
        //将自定义的realm加进来
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myAuthRealm());
        log.info("=======securityManager注入完成");
        return manager;
    }

    //配置shiro过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        //定义ShiroFilterFactoryBean,设置成自定义的安全管理器对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置自定义的安全管理器对象
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //进行拦截器配置,设置请求过滤规则
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //静态资源的放行
        filterChainDefinitionMap.put("/css/**","anon");
        //登陆功能的放行
        filterChainDefinitionMap.put("/login","anon");
        //核心资源的拦截
        filterChainDefinitionMap.put("/testShiro","authc");//此核心资源表示只要用户登录成功便可访问，不需要该用户携带任何权限表示信息
        filterChainDefinitionMap.put("/log/**", "authc");
        //filterChainDefinitionMap.put("/testShiro", "roles[admin]");//此核心资源表示登录用于需要携带admin的角色权限才可访问此链接
//        filterChainDefinitionMap.put("/shiro","authc");//此核心资源被拦截到登录页面，在登陆页面用户登陆成功即可访问此链接
        //用户权限认证，仅admin放行
        //filterChainDefinitionMap.put("/testShiro","roles[admin]");
        //用户权限认证，含对应权限标识则放行
        filterChainDefinitionMap.put("/testSuccess","authc,perms[user:list]");//访问此资源需要用户携带权限标识user:list
        filterChainDefinitionMap.put("/testSuccess", "authc,roles[admin]");//访问此资源需要用户携带角色权限信息admin
       // filterChainDefinitionMap.put("/testShiro","perms[\"admin:query\"]");

        //设置退出登录按钮
        filterChainDefinitionMap.put("/logout","logout");

        //对上述之外的地址栏中的所有亲求施行拦截
        //filterChainDefinitionMap.put("/**", "authc");

        //设置默认登录的url,用户登录失败会访问该url,设置此项的目的是让用户进行登录认证
        shiroFilterFactoryBean.setLoginUrl("/login");//设置默认登陆的url，当用户访问拦截的地址时跳转到此链接
        //shiroFilterFactoryBean.setSuccessUrl("/ShiroSuccess");//设置登陆成功的url，一般不需要设置，通过controller层的return实现登陆成功跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error1");//当用户访问某资源却没有对应的访问权限时,跳转到此链接
        //将过滤链载入过滤器,固定格式
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


}
