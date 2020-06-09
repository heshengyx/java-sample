package com.hsheng.core.thread.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/6/5 9:08
 * @since TODO
 */
public class Future2 {

    private final Executor executor = Executors.newFixedThreadPool(Math.min(4, 100),//创建一个线程池，线程池中线程数目为100和商店数目二者中较小的一个值
            new ThreadFactory() {
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    t.setDaemon(true);//使用守护线程，这种方式不会阻止程序的关停
                    return t;
                }
            });

    private String name;

    public Future2(String name) {
        this.name = name;
    }

    private static final Random random = new Random();

    /**
     * 同步获取价格
     * @param product
     * @return
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * 异步获取价格
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();//创建CompletableFuture对象，它会包含计算结果
        /*new Thread(() -> {
            double price = calculatePrice(product);//在另一个线程中以异步方式执行计算
            futurePrice.complete(price);//需长时间计算的任务结束并得出结果时，设置Future的返回值
        }).start();*/
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);//如果价格计算正常结束，完成Future操作并设置商品价格
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);//否则抛出导致失败的异常，完成这次Future操作
            }
        }).start();
        return futurePrice;//无需等待还没结束的计算，直接返回Future对象
    }

    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product), executor);
    }

    private double calculatePrice(String product) {
        delay();
        //int i = 1/0;
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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

    public static void main(String[] args) {
        Future2 shop = new Future2("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync2("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime);
        doSomethingElse(); //执行更多任务

        try {
            double price = futurePrice.get(2, TimeUnit.SECONDS);//从Future对象中读取价格，如果价格未知，会发生阻塞
            System.out.printf("Price is %.2f%n", price);
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

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

}
