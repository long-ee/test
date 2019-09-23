package com.am.plus.controller;

import com.am.plus.entity.User;
import com.am.plus.mapper.UserMapper;
import com.am.plus.service.UserService;
import com.am.plus.untils.AjaxResult;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author long
 * @since 2019-09-04
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AjaxResult ajaxResult;
    @RequestMapping("/assignRole")
    public String assignRole(){
        return "/role/assignRole";

    }
    @RequestMapping("/role")
    public String role(){
        return "/role/role";
    }
    @RequestMapping("/assignPermission")
    public String assignPermission(){
        return "/role/Permission";
    }
    @RequestMapping("/user")
    public String userList(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize, String username, String account, Map map){
        PageInfo<User> userByVague = userService.getUserByVague(pageNum, pageSize, username, account);
        map.put("pageinfo", userByVague);
        return "user";
    }
}
