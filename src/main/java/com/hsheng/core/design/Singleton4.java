/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package com.hsheng.core.design;

/**
 * @description 静态内部类实现模式（线程安全，调用效率高，可以延时加载）
 * @author hesheng
 * @date 2019/12/23 16:17
 * @since TODO
 */
public class Singleton4 {

    private Singleton4() {}

    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton4 instance = new Singleton4();
    }
}
