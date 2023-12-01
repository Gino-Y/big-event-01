package com.itheima.pojo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Category {
    private Integer id;
    private String categoryName;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    // getters and setters
}
