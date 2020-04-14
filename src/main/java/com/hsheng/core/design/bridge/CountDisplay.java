package com.hsheng.core.design.bridge;

/**
 * @description 桥接模式
 * @author hesheng
 * @date 2020/4/14 8:17
 * @since TODO
 */
public class CountDisplay extends Display {

    public CountDisplay(AbstDisplay display) {
        super(display);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
