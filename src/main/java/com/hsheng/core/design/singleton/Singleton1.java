package com.hsheng.core.design.singleton;

/**
 * @description 单例模式-饿汉式(线程安全，调用效率高，但是不能延时加载)
 * @author hesheng
 * @date 2019/12/23 13:54
 * @since TODO
 */
public class Singleton1 {

    private static Singleton1 instance = new Singleton1();

    /**
     * 私有构造器
     */
    private Singleton1() {}

    public static Singleton1 getInstance() {
        return instance;
    }
}
