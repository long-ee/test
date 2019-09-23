package com.am.plus.login.controller;


import com.am.plus.entity.User;
import com.am.plus.untils.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AjaxResult ajaxResult;
    @RequestMapping("/toLogin")
    public String login(){
        return "login" ;
    }
    @RequestMapping("/unauthor")
    public String unauthor(){
        return "unauthor";
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @ResponseBody
    @RequestMapping("/doLogin")
    public Object doLogin(User user){
        log.info("======="+user);
        System.out.println(user);
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token=new UsernamePasswordToken(user.getAccount(),user.getPassword());
            try {
                currentUser.login(token);
            } catch (UnknownAccountException e) {
                log.info(e.getMessage());
              ajaxResult.setMsg("您输入的账号不存在");
              ajaxResult.setSuccess(false);
              return ajaxResult;
            }
            catch (IncorrectCredentialsException es){
                log.info(es.getMessage());
                ajaxResult.setMsg("您输入的密码不正确");
                ajaxResult.setSuccess(false);
                return ajaxResult;
            }
            ajaxResult.setMsg("登陆成功");
            ajaxResult.setSuccess(true);
            ajaxResult.setUrl("/login/main");
        }

        return ajaxResult;

    }
}
