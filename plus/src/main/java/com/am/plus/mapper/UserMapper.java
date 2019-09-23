package com.am.plus.mapper;

import com.am.plus.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author long
 * @since 2019-09-04
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserListByVague(@Param("username") String username, @Param("account")String account);
}
