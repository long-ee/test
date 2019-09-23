package com.am.plus.shrio;


import com.am.plus.entity.User;
import com.am.plus.login.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import sun.util.resources.LocaleData;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public class LoginRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证执行");
        UsernamePasswordToken token1= (UsernamePasswordToken) token;
        String account = token1.getUsername();
        System.out.println(account+"account");
        List<User> userByAccount = loginService.getUserByName(account);
        if (userByAccount.isEmpty()){
            throw new UnknownAccountException("账户不存在");
        }
        System.out.println(userByAccount.get(0).getPassword()+"fdfd");

        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(account,userByAccount.get(0).getPassword(),getName());
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权执行");
        return null;
    }

//    public static void main(String[] args) {
//
//        System.out.println(LocalDateTime.now().getDayOfYear());
//    }
}
