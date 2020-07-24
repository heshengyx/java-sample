package com.hsheng.core.thread.threadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/7/23 9:31
 * @since TODO
 */
public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newCachedThreadPool(
                        new HandlerThreadFactory());
        exec.execute(new ExceptionThread());
        exec.shutdown();
    }
}

class ExceptionThread implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t.getName());
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements
        Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + " caught " + e);
    }
}

/**
 * 线程工厂, 用来产生新线程
 */
class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);

        //设置单个线程异常处理器
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler());
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}