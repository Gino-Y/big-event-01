package com.itheima.pojo;

import com.itheima.anno.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Integer id;
    @NotEmpty
    @Pattern(regexp="^\\S{1,10}$", message = "标题长度为1-10个字符")
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    @URL(message = "封面图片地址不合法")
    private String coverImg;
    @State
    private String state;
    @NotNull
    private Integer categoryId;
    private Integer createUser;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    // getters and setters
}
