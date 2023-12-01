package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password) {
        // 查询用户
        User u = userService.findByUsername(username);
        if (u == null) {
            // 没有占用，注册
            userService.register(username);
            return Result.success();
        }else {
            // 已经被占用
            return Result.error("用户名已经被占用");
        }

        // 注册
    }
}
