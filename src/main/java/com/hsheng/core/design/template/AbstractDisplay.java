package com.hsheng.core.design.template;

/**
 * @description 模板模式-抽象模板类
 * @author hesheng
 * @date 2020/1/7 18:23
 * @since TODO
 */
public abstract class AbstractDisplay {

    /**
     * 打开
     */
    abstract void open();

    /**
     * 打印
     */
    abstract void print();

    /**
     * 关闭
     */
    abstract void close();

    /**
     * 显示
     */
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
