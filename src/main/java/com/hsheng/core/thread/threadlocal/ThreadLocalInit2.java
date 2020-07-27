package com.hsheng.core.thread.threadlocal;

/**
 * @description 借助于inheritableThreadLocals，可以实现，创建线程向被创建线程数据传递
 * @author hesheng
 * @date 2020/7/24 13:39
 * @since TODO
 */
public class ThreadLocalInit2 {

    public static void main(String[] args) {
        //主线程中赋值
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

        InheritableThreadLocal<String> stringInheritableThreadLocal = new InheritableThreadLocal<>();

        stringThreadLocal.set("ThreadLocal string");
        stringInheritableThreadLocal.set("InheritableThreadLocal string");

        //子线程中分别打印两个变量的信息
        new Thread(() -> {
            System.out.println(
                    Thread.currentThread().getName() + " ThreadLocal value ：" + stringThreadLocal.get());
            System.out.println(Thread.currentThread().getName() + " InheritableThreadLocal value ："
                    + stringInheritableThreadLocal.get());
        }).start();
    }
}
