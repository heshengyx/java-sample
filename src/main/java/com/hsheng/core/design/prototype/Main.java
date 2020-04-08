package com.hsheng.core.design.prototype;

/**
 * @description 原型模式
 * @author hesheng
 * @date 2020/4/8 8:22
 * @since TODO
 */
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Product box1 = new MessageBox('*');
        Product box2 = new MessageBox('/');
        manager.register("box1", box1);
        manager.register("box2", box2);

        Product p1 = manager.create("box1");
        p1.use("Hello");
        Product p2 = manager.create("box2");
        p2.use("Hello");
    }
}
