/**
 * @Copyright (c) 2019, Denali System Co., Ltd. All Rights Reserved.
 * Website: www.denalisystem.com | Email: marketing@denalisystem.com
 */
package com.hsheng.core.design.singleton;

/**
 * @description 单例模式-枚举类（线程安全，调用效率高，不能延时加载，可以天然的防止反射和反序列化调用）
 * @author hesheng
 * @date 2019/12/23 16:20
 * @since TODO
 */
public class Singleton5 {

    private Singleton5() {}

    public static Singleton5 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    /**
     * 枚举类
     */
    private enum SingletonEnum {
        INSTANCE;

        private Singleton5 instance;

        SingletonEnum() {
            instance = new Singleton5();
        }

        public Singleton5 getInstance() {
            return instance;
        }
    }
}
