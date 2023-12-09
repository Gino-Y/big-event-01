package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Integer id;
    private String categoryName;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    // getters and setters
}
