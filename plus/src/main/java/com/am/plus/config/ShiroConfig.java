package com.am.plus.config;

import com.am.plus.shrio.LoginRealm;
import com.am.plus.shrio.UserRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.security.krb5.Realm;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
   @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
		/*filterMap.put("/add", "authc");
		filterMap.put("/update", "authc");*/

        filterMap.put("/login/*", "anon");

        filterMap.put("/*", "authc");

        //修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("/login/toLogin");
        shiroFilterFactoryBean.setSuccessUrl("/login/main");
        shiroFilterFactoryBean.setUnauthorizedUrl("/login/unauthor");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }




    @Bean("defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("loginRealm") LoginRealm loginRealm ){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(loginRealm);
        return defaultWebSecurityManager;
    }

    @Bean("userRealm")
    public UserRealm realm(){
        return new UserRealm();
    }
    @Bean("loginRealm")
    public LoginRealm loginRealm(@Qualifier("matcher") HashedCredentialsMatcher matcher){
       LoginRealm loginRealm=new LoginRealm();
       loginRealm.setCredentialsMatcher(matcher);
       return loginRealm;
    }
    @Bean("matcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
       HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
       matcher.setHashAlgorithmName("MD5");
       matcher.setHashIterations(1024);
       return matcher;
    }
//    @Bean("CredentialsMatcher")
//    public CredentialsMatcher credentialsMatcher(@Qualifier("matcher") HashedCredentialsMatcher matcher){
//       return matcher;
//    }

}
