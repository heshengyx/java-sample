package com.hsheng.core.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @description 线程本地变量
 * @author hesheng
 * @date 2020/3/2 21:06
 * @since TODO
 */
public class ThreadLocalDemo {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                //设置当前线程本地变量的值
                threadLocal.set(Thread.currentThread().getName() + "的变量");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //获取当前线程本地变量的值
                System.out.println(Thread.currentThread().getName() + "--->" + threadLocal.get());
            }).start();
        }
        //手动执行remove方法清理掉不再使用的key-value, 避免内存泄漏
        threadLocal.remove();
    }
}
