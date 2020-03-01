package com.hsheng.core.design.adapter.a02;

/**
 * @description 适配器模式
 * @author hesheng
 * @date 2020/1/7 16:55
 * @since TODO
 */
public class Banner {

    private String name;

    public Banner(String name) {
        this.name = name;
    }

    public void showWithParen() {
        System.out.println("(" + name + ")");
    }

    public void showWithAster() {
        System.out.println("*" + name + "*");
    }
}
