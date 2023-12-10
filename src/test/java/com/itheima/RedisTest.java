package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest// 标记这是一个springboot测试类
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        operations.set("username", "张三");
        // 存储对象的时候可以设置过期时间
        operations.set("id", "1", 15, TimeUnit.SECONDS);

    }

    @Test
    public void testGet(){
        // 从redis中获取数据
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        String username = operations.get("username");

        System.out.println("username = " + username);
    }
}
