package com.hsheng.core.design.template;

/**
 * @description 抽象模板类
 * @author hesheng
 * @date 2020/1/7 18:23
 * @since TODO
 */
public abstract class AbstractDisplay {

    abstract void open();
    abstract void print();
    abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
