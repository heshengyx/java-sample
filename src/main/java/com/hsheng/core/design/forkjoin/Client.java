package com.hsheng.core.design.forkjoin;

import java.util.Random;

/**
 * @description Master-Worker模式
 * @author hesheng
 * @date 2020/6/21 10:05
 * @since TODO
 */
public class Client {

    public static void main(String[] args) {
        Master master = new Master(new Worker(), 10);
        for (int i = 0; i < 100; i++) {
            Task task = new Task();
            task.setId(i);
            task.setName("任务" + i);
            task.setPrice(new Random().nextInt(10000));
            master.submit(task);
        }

        master.execute();

        while (true) {
            if (master.isComplete()) {
                System.out.println("执行的结果为: " + master.getResult());
                break;
            }
        }
    }
}
