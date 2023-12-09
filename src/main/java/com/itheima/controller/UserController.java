package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.JwtUtil;
import com.itheima.utils.Md5Util;
import com.itheima.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查询用户
        User u = userService.findByUserName(username);
        if (u == null) {
            // 没有占用，注册
            userService.register(username, password);
            // 判断是否注册成功
            User user = userService.findByUserName(username);
            if (user != null) {
                // 注册成功
                return Result.success();
                // 返回当前用户信息
                // return Result.success(user);
            }else {
                // 注册失败
                return Result.error("注册失败");
            }
        }else {
            // 已经被占用
            return Result.error("用户名已经被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);

        // 判断用户是否存在
        if (loginUser == null) {
            return Result.error("用户名不存在");
        }

        // 判断密码是否正确 loginUser对象中的password是加密后的密码
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            // 登录成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name="Authorization") String token*/){
        // 根据用户名查询用户
        // 解析token
        /*Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");*/

        // 从ThreadLocal中获取用户信息
        Map<String, Object> map= ThreadLocalUtil.get();
        String username = (String)map.get("username");

        User user = userService.findByUserName(username);
        return Result.success(user);

    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }




//    //这些事手写校验的代码，现在不需要了
//    @PostMapping("/register")
//    public Result register(String username, String password) {
//
//        if (username != null && username.length() >= 5 && username.length() <= 16 &&
//            password != null && password.length() >= 5 && password.length() <= 16){
//            // 查询用户
//            User u = userService.findByUserName(username);
//            if (u == null) {
//                // 没有占用，注册
//                userService.register(username, password);
//                // 判断是否注册成功
//                User user = userService.findByUserName(username);
//                if (user != null) {
//                    // 注册成功
//                    return Result.success();
//                    // 返回当前用户信息
//                    // return Result.success(user);
//                }else {
//                    // 注册失败
//                    return Result.error("注册失败");
//                }
//            }else {
//                // 已经被占用
//                return Result.error("用户名已经被占用");
//            }
//        }else {
//            // 参数不完整
//            return Result.error("参数不合法");
//        }
//    }


}
