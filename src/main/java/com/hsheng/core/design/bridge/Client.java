package com.hsheng.core.design.bridge;

/**
 * @description 桥接模式
 * @author hesheng
 * @date 2020/4/14 8:22
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello CN"));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello world"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello US"));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }
}
