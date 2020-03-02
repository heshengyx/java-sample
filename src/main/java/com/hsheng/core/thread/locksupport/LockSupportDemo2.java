package com.hsheng.core.thread.locksupport;

import java.util.concurrent.TimeUnit;

/**
 * @description 唤醒与阻塞-wait and notify
 * @author hesheng
 * @date 2020/3/2 21:52
 * @since TODO
 */
public class LockSupportDemo2 {

    private static String message;

    /**
     * 线程1先执行会睡眠3秒，线程2先执行了notify去唤醒thread1
     * 而在3秒后thread1才会执行wait方法，它将一直阻塞在这里
     * 所以wait/notify方法的执行顺序会影响到线程唤醒
     * @param args
     */
    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock) {
                try {
                    lock.wait(); //当前线程阻塞
                } catch (InterruptedException e) {}
            }
            System.out.println(message);
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "thread2 wakes up thread1";
                lock.notify(); //随机唤醒阻塞中的线程
            }
        });

        thread1.start();
        thread2.start();
    }
}
