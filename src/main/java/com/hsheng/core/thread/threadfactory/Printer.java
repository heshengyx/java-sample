package com.hsheng.core.thread.threadfactory;

/**
 * @description 线程
 * @author hesheng
 * @date 2020/4/20 8:12
 * @since TODO
 */
public class Printer implements Runnable {

    private String message;

    public Printer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(message);
        }
    }
}
