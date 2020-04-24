package com.hsheng.core.thread.hook;

import java.util.concurrent.TimeUnit;

/**
 * @description 捕获线程异常
 * @author hesheng
 * @date 2020/4/24 8:47
 * @since TODO
 */
public class CaptureThreadException {

    public static void main(String[] args) {

        /**
         * setUncaughtExceptionHandler: 为某个特定线程指定UncaughtExceptionHandler
         * setDefaultUncaughtExceptionHandler: 设置全局的UncaughtExceptionHandler
         */
        //设置全局线程异常回调接口
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " occur exception");
                e.printStackTrace();
            }
        });

        /**
         * 打印线程组信息
         */
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainGroup.getName());
        System.out.println(mainGroup.getParent());
        System.out.println(mainGroup.getParent().getParent());

        /**
         * 创建线程
         */
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //抛出非检查异常
            System.out.println(1 / 0);
        }, "Test-Thread");
        thread.start(); //启动线程
    }
}
