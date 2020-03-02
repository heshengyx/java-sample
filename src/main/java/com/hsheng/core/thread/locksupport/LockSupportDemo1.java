package com.hsheng.core.thread.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @description 唤醒与阻塞-park and unpark
 * @author hesheng
 * @date 2020/3/2 21:40
 * @since TODO
 */
public class LockSupportDemo1 {

    private static String message;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (message == null) {
                //对当前线程进入阻塞状态，直到获取可用许可后才解除阻塞
                LockSupport.park();
            }
            System.out.println(message);
        });

        Thread thread2 = new Thread(() -> {
            message = "thread2 wakes up thread1";
            //唤醒线程，将指定线程的许可置为可用
            LockSupport.unpark(thread1);
        });

        thread1.start();
        TimeUnit.SECONDS.sleep(3);
        thread2.start();
    }
}
