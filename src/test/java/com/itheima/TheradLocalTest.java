package com.itheima;

import org.junit.jupiter.api.Test;

public class TheradLocalTest {
    @Test
    public void testThreadLocalSetAndGet() {
        // 创建ThreadLocal对象
        ThreadLocal tl = new ThreadLocal();

        // 开启两个线程
        new Thread(()->{
            tl.set("萧衍");
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
        }, "蓝色").start();

        new Thread(()->{
            tl.set("姚晨");
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
        }, "红色").start();
    }
}
