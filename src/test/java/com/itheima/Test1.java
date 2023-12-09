package com.itheima;

import com.itheima.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test1 {

    @Autowired
    private UserMapper userMapper;

    // 添加用户
    @Test
    public void testAdd(){
        userMapper.add("zhangsan1","123456");
    }

    // 根据用户名查询用户
    @Test
    public void testFindByUserName(){
        System.out.println(userMapper.findByUserName("zhangsan"));
    }


}
