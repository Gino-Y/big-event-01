package com.itheima.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @NotNull(groups = {Update.class})
    private Integer id;
    @NotEmpty/*(message = "分类名称不能为空", groups = {Add.class, Update.class})*/
    private String categoryName;
    @NotEmpty/*(message = "分类别名不能为空", groups = {Add.class, Update.class})*/
    private String categoryAlias;
    @JsonIgnore // 返回json数据时忽略该字段
    private Integer createUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    // 如果某个校验注解没有指定groups属性，则该校验注解属于Default组
    // 分组之间可以继承，比如Update组继承了Default组。例如Update extends Default

    public interface Add extends Default {

    }

    public interface Update extends Default{

    }

}
