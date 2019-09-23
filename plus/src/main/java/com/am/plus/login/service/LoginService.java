package com.am.plus.login.service;



import com.am.plus.entity.User;

import java.util.List;

public interface LoginService {
    List<User> getUserByName(String name);
}
