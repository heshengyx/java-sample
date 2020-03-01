package com.hsheng.core.design.adapter.a01;

/**
 * @description 适配器模式-客户端
 * @author hesheng
 * @date 2020/1/7 17:03
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");
        print.printWeak();;
        print.printStrong();
    }
}
