package com.hsheng.core.thread.threadlocal;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/7/24 11:25
 * @since TODO
 */
public class ThreadLocalInit1 {

    static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "helloword");

    static final String s = new String("hello");

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " value1=" + threadLocal.get()); //helloword
        threadLocal.set(s);
        System.out.println(Thread.currentThread().getName() + " value1=" + threadLocal.get()); //good!
        threadLocal.remove();
        System.out.println(Thread.currentThread().getName() + " value1=" + threadLocal.get()); //helloword

        new Thread(() -> {
            threadLocal.set(s);
            System.out.println(Thread.currentThread().getName() + " value1=" + threadLocal.get()); //helloword
        }, "thread1").start();
    }
}
