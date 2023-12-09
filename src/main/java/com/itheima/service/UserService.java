package com.itheima.service;

import com.itheima.pojo.User;

public interface UserService {
    // 根据用户名查询用户信息
    User findByUserName(String username);

    // 注册用户
    void register(String username);

    void register(String username, String password);

    // 修改用户信息
    void update(User user);

    // 修改头像
    void updateAvatar(String avatarUrl);

    // 修改密码
    void updatePwd(String newPwd);
}
