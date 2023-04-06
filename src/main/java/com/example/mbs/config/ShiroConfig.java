package com.example.mbs.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //shiroFilterBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /**
         *  anon    无需认证即可访问
         *  authc   必须认证才能访问
         *  user    必须拥有记住我功能才能用
         *  perms   拥有对某个资源的权限才能访问
         *  role    拥有某个角色权限才能访问
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

        //必须认证才能访问
        filterMap.put("/index","authc");
        filterMap.put("/myMessage","authc");
        filterMap.put("/message/search","authc");
        filterMap.put("/personal","authc");

        //配置注销链接
        filterMap.put("/loginout","logout");

        bean.setFilterChainDefinitionMap(filterMap);


        //如果没有权限设置跳转到登入界面
        bean.setLoginUrl("/login");

        return bean;
    }


    //DefaultWebSecurityManager
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);

        return securityManager;
    }

    //创建 realm 对象
    @Bean(name="userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
