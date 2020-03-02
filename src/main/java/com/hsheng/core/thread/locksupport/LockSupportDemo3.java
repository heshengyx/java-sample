package com.hsheng.core.thread.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @description 唤醒与阻塞-park and unpark
 * @author hesheng
 * @date 2020/3/2 22:03
 * @since TODO
 */
public class LockSupportDemo3 {

    private static String message;

    /**
     * park/unpark方式的执行顺序不影响线程唤醒，因为park/unpark使用许可机制
     * 如果先调用unpark去释放许可，那么调用park时就直接获取许可而不必等待
     * @param args
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //对当前线程进入阻塞状态，直到获取可用许可后才解除阻塞
            LockSupport.park();
            System.out.println(message);
        });

        Thread thread2 = new Thread(() -> {
            message = "thread2 wakes up thread1";
            //唤醒线程，将指定线程的许可置为可用
            LockSupport.unpark(thread1);
        });

        thread1.start();
        thread2.start();
    }
}
