package com.hsheng.core.thread.threadfactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @description 线程
 * @author hesheng
 * @date 2020/4/20 8:15
 * @since TODO
 */
public class Client2 {

    public static void main(String[] args) {
        //在新线程中执行
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new Printer("Nice!")).start();

        //在主线程中执行
        for (int i = 0; i < 100; i++) {
            System.out.println("Good!");
        }
    }
}
