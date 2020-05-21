package com.hsheng.core.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description 多等一
 * @author hesheng
 * @date 2020/5/21 8:25
 * @since TODO
 */
public class CountDownLatch1 {

    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            final int num = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("No." + num + "准备完毕，等待发令枪");
                    try {
                        begin.await();
                        System.out.println("No." + num + "开始跑步了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.submit(runnable);
        }

        //
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发令枪响，比赛开始！");
        begin.countDown();
    }
}
