package com.am.plus.service.impl;

import com.am.plus.entity.User;
import com.am.plus.mapper.UserMapper;
import com.am.plus.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author long
 * @since 2019-09-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public PageInfo<User> getUserByVague(Integer pageNum, Integer pageSize, String username, String account) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.getUserListByVague(username, account);
        PageInfo<User> pageInfo=new PageInfo<>(users,5);
        System.out.println(pageInfo);
        return pageInfo;
    }
}
