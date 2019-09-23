package com.am.plus.service;

import com.am.plus.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author long
 * @since 2019-09-04
 */
public interface UserService extends IService<User> {
    PageInfo<User>   getUserByVague(Integer pageNum, Integer pageSize, String username, String account);
}
