package com.hsheng.core.loader;

/**
 * @description 线程上下文类加载器
 * @author hesheng
 * @date 2020/4/26 9:47
 * @since TODO
 */
public class ThreadClassLoader {

    public static void main(String[] args) {
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        //获取当前线程上下文类加载器
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
