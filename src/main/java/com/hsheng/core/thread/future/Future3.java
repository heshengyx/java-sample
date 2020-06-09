package com.hsheng.core.thread.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/6/5 9:54
 * @since TODO
 */
public class Future3 {

    /**
     * 执行任务A,同时异步执行任务B,待任务B正常返回之后,用B的返回值执行任务C,任务C无返回值
     */
    public void thenApply() {
        //CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "任务A");
        //CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> "任务B");
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行任务A.");
            return "任务A";
        });
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行任务B.");
            return "任务B";
        });
        CompletableFuture<String> futureC = futureB.thenApply(b -> {
            System.out.println("执行任务C.");
            System.out.println("参数:" + b);//参数:任务B
            return "a";
        });
        Future<String> future = futureC;
        try {
            String result = future.get();
            System.out.println("result=" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行任务A,任务A执行完以后,执行任务B,任务B不接受任务A的返回值(不管A有没有返回值),也无返回值
     */
    public void thenRun() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> "任务A");
        futureA.thenRun(() -> System.out.println("执行任务B"));
    }

    public static void main(String[] args) {
        Future3 future3 = new Future3();
        future3.thenApply();
        future3.thenRun();
    }


}
