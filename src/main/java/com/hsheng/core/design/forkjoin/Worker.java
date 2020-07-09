package com.hsheng.core.design.forkjoin;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description Master-Worker模式
 * @author hesheng
 * @date 2020/6/21 10:02
 * @since TODO
 */
public class Worker implements Runnable {

    private ConcurrentLinkedQueue<Task> taskQueue;
    private ConcurrentHashMap<String, Object> resultMap;

    public ConcurrentLinkedQueue<Task> getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(ConcurrentLinkedQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public ConcurrentHashMap<String, Object> getResultMap() {
        return resultMap;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (true) {
            Task task = this.taskQueue.poll();
            // 所有任务已经执行完毕
            if (task == null) {
                break;
            }
            // 模拟对task进行处理, 返回结果
            int result = task.getPrice();
            this.resultMap.put(task.getId() + "", result);
            System.out.println("任务执行完毕, 当前线程: " + Thread.currentThread().getName());
        }
    }
}
