package com.hsheng.core.design.singleton;

/**
 * @description 单例模式-volatile+双重锁判断机制
 * @author hesheng
 * @date 2019/12/23 13:59
 * @since TODO
 */
public class Singleton3 {

    /**
     * volatile禁止指令重排序
     * 1 memory = allocate() 分配对象内存空间
     * 2 ctorInstance() 初始化对象
     * 3 instance = memory 设置instance指向刚分配的内存
     */
    private volatile static Singleton3 instance;

    /**
     * 私有构造器
     */
    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
