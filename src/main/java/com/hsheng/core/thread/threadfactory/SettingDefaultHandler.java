package com.hsheng.core.thread.threadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description 设置为默认的未捕获异常处理器
 * @author hesheng
 * @date 2020/7/23 9:36
 * @since TODO
 */
public class SettingDefaultHandler {

    public static void main(String[] args) {
        //设置全局默认异常处理器
        //只有在每个线程没有设置异常处理器时候，默认处理器才会被调用
        Thread.setDefaultUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler());
        ExecutorService es =
                Executors.newCachedThreadPool();
        es.execute(new ExceptionThread());
        es.shutdown();
    }
}
