package com.hsheng.core.design;

/**
 * @description 懒汉式(线程安全，调用效率不高，但是能延时加载
 * @author hesheng
 * @date 2019/12/23 13:56
 * @since TODO
 */
public class Singleton2 {

    /**
     * 类初始化时，不初始化这个对象(延时加载，真正用的时候再创建)
     */
    private static Singleton2 instance;

    /**
     * 私有构造器
     */
    private Singleton2() {}

    /**
     * 方法同步，调用效率低
     * @return
     */
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
