package com.hsheng.core.design.decorator;

/**
 * @description 装饰器模式
 * @author hesheng
 * @date 2020/4/17 8:43
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        Display display1 = new StringDisplay("Hello, world");
        Display display2 = new SideBorder(display1, '#');
        Display display3 = new FullBorder(display2);
        display1.show();
        display2.show();
        display3.show();
    }
}
