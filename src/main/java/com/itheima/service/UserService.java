package com.itheima.service;

import com.itheima.pojo.User;

public interface UserService {
    // 根据用户名查询用户信息
    User findByUserName(String username);

    // 注册用户
    void register(String username);

    void register(String username, String password);

    User findByUsername(String username);
}
