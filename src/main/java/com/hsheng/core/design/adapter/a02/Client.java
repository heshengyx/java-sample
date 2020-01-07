package com.hsheng.core.design.adapter.a02;

/**
 * @description TODO
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
