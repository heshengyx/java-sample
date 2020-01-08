package com.hsheng.core.design.factory;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/8 8:46
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product product1 = factory.create("小明");
        Product product2 = factory.create("小红");
        Product product3 = factory.create("小张");

        product1.use();
        product2.use();
        product3.use();
    }
}
