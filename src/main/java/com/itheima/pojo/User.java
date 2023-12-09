package com.itheima.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//lombok 在编译阶段自动生成getter setter toString方法
//需要在pom.xml中引入lombok依赖,并且在实体类上加上@Data注解
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull
    private Integer id;
    private String username;
    @JsonIgnore // 返回json数据时忽略该字段
    private String password;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;
    @NotEmpty
    @Email
    private String email;
    private String userPic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    // getters and setters
}
