package com.hsheng.core.design.bridge;

/**
 * 类的功能层次(在子类中增加新功能)
 * 类的实现层次(在子类中实现父类功能)
 * @description 桥接模式
 * @author hesheng
 * @date 2020/4/14 8:13
 * @since TODO
 */
public class Display {

    private AbstDisplay display;

    public Display(AbstDisplay display) {
        this.display = display;
    }

    public void open() {
        display.rawOpen();
    }

    public void print() {
        display.rawPrint();
    }

    public void close() {
        display.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
