package com.hsheng.core.design.template;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/7 18:30
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        AbstractDisplay display1 = new CharDisplay('H');
        AbstractDisplay display2 = new StringDisplay("Hello");
        AbstractDisplay display3 = new StringDisplay("你好");

        display1.display();
        display2.display();
        display3.display();
    }
}
