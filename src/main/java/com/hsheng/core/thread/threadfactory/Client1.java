package com.hsheng.core.thread.threadfactory;

/**
 * @description 线程
 * @author hesheng
 * @date 2020/4/20 8:13
 * @since TODO
 */
public class Client1 {

    public static void main(String[] args) {
        new Thread(new Printer("Good!")).start();
        new Thread(new Printer("Nice!")).start();
    }
}
