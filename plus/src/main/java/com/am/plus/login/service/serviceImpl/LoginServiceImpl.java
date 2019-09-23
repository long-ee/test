package com.am.plus.login.service.serviceImpl;


import com.am.plus.entity.User;
import com.am.plus.login.service.LoginService;
import com.am.plus.mapper.UserMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, com.am.plus.entity.User> implements LoginService {
    public List<User>  getUserByName(String account){
        Map map=new HashMap();
        map.put("account", account);
        List<User> list = baseMapper.selectByMap(map);
        return list;
    }
}
