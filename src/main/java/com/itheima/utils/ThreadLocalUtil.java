package com.itheima.utils;

public class ThreadLocalUtil {
    //提供ThreadLocal对象
    private static final ThreadLocal THREAC_LOCAL = new ThreadLocal();

    //根据键获取值
    public static<T> T get(){
        return (T)THREAC_LOCAL.get();
    }

    //存储键值对
    public static void set(Object value){
        THREAC_LOCAL.set(value);
    }

    //清除ThreadLocal防止内存泄漏
    public static void remove(){
        THREAC_LOCAL.remove();
    }
}
