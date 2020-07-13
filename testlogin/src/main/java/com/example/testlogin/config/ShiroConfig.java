package com.example.testlogin.config;

import com.shiro.testshiro.realms.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration//用来声明替换xml的类，常与@Bean搭配使用
public class ShiroConfig {
    private static final Logger logger = LoggerFactory.getLogger(com.shiro.testshiro.config.ShiroConfig.class);





    //注入自定义的realm
    @Bean
    public MyRealm myAuthRealm(){
        MyRealm myRealm = new MyRealm();
        logger.info("=====myRealm注入完成");
        return myRealm;
    }

    //注入安全管理器对象
    @Bean
    public DefaultWebSecurityManager securityManager(){
        //将自定义的realm加进来
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myAuthRealm());
        logger.info("=======securityManager注入完成");
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
        filterChainDefinitionMap.put("/testShiro","authc");
//        filterChainDefinitionMap.put("/shiro","authc");
        //用户权限认证，仅admin放行
        //filterChainDefinitionMap.put("/testShiro","roles[admin]");
        //用户权限认证，含对应权限标识则放行
        filterChainDefinitionMap.put("/testSuccess","authc,perms[user:list]");
       // filterChainDefinitionMap.put("/testShiro","perms[\"admin:query\"]");

        //设置退出登录按钮
        filterChainDefinitionMap.put("/logout","logout");

        //对上述之外的地址栏中的所有亲求施行拦截
        //filterChainDefinitionMap.put("/**", "authc");

        //设置默认登录的url,用户登录失败会访问该url,设置此项的目的是让用户进行登录认证
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/ShiroSuccess");
        shiroFilterFactoryBean.setUnauthorizedUrl("/error1");
        //将过滤链载入过滤器,固定格式
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


}
