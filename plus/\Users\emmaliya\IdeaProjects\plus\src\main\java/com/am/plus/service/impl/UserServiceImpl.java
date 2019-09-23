package com.am.plus.service.impl;

import com.am.plus.entity.User;
import com.am.plus.mapper.UserMapper;
import com.am.plus.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author long
 * @since 2019-09-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
