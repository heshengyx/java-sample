package com.hsheng.core.thread.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/6/5 8:46
 * @since TODO
 */
public class Future1 {

    private static final Random random = new Random();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() { //向ExecutorService提交一个Callable对象
            public Double call() {
                return doSomeLongComputation();//以异步方式在新线程中执行耗时的操作
            }
        });
        doSomethingElse();
        try {
            Double result = future.get(1, TimeUnit.SECONDS);//获取异步操作结果，如果被阻塞，无法得到结果，在等待1秒钟后退出
            System.out.println("result=" + result);
        } catch (ExecutionException ee) {
            // 计算抛出一个异常
            System.out.println("计算抛出一个异常");
        } catch (InterruptedException ie) {
            // 当前线程在等待过程中被中断
            System.out.println("当前线程在等待过程中被中断");
        } catch (TimeoutException te) {
            // 在Future对象完成之前超时
            System.out.println("在Future对象完成之前超时");
        }
    }

    private static void doSomethingElse() {
        System.out.println("doSomethingElse starting...");
        //randomDelay();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSomethingElse end...");
    }

    private static Double doSomeLongComputation() {
        System.out.println("doSomeLongComputation starting...");
        randomDelay();
        System.out.println("doSomeLongComputation end...");
        return 0.0;
    }

    /**
     * 随机延时
     */
    private static void randomDelay() {
        long delay = 500 + random.nextInt(2000);
        try {
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
