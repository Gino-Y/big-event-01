package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code; // 状态码 0 表示成功，-1表示失败
    private String message; // 提示信息
    private T data; // 响应数据

    // 快速返回操作成功响应的结果（带响应数据）
    public static <T> Result<T> success(T data) {
        return new Result<T>(0, "操作成功", data);
    }

    // 快速返回操作成功响应的结果
    public static Result success() {
        return new Result (0, "操作成功", null);
    }

    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
