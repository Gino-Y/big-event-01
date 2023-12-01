package com.itheima.pojo;

import lombok.Data;

import java.time.LocalDateTime;
//lombok 在编译阶段自动生成getter setter toString方法
//需要在pom.xml中引入lombok依赖,并且在实体类上加上@Data注解
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String userPic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    // getters and setters
}
