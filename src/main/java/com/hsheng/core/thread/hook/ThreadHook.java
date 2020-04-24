package com.hsheng.core.thread.hook;

import java.util.concurrent.TimeUnit;

/**
 * 1、在 kill 的时候使用了参数－9, 那么 Hook 线程不会得到执行
 * 2、Hook 线程中也可以执行一些资源释放的工作， 比如关闭文件句柄、 socket 链接、 数 据库 connection
 * 3、尽量不要在 Hook 线程中执行一些耗时非常长的操作，因为其会导致程序迟迟不能退出
 * @description TODO
 * @author hesheng
 * @date 2020/4/24 9:08
 * @since TODO
 */
public class ThreadHook {

    public static void main(String[] args) {

        /**
         * 为应用程序注入退出钩子线程
         */
        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println("The hook thread 1 is running.");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The hook thread 1 will exit.");
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println("The hook thread 2 is running.");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The hook thread 2 will exit.");
            }
        });
        System.out.println("The program will is stopping.");
    }
}
