package com.hsheng.core.disruptor.d2;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/30 20:04
 * @since TODO
 */
public class Client {

    public static void main(String[] args) throws Exception {

        //创建RingBuffer
        RingBuffer<Order> ringBuffer = RingBuffer.create(ProducerType.MULTI, new EventFactory<Order>() {
            @Override
            public Order newInstance() {
                return new Order();
            }
        }, 1024 * 1024, new YieldingWaitStrategy());
        //YieldingWaitStrategy等待策略

        //通过ringBuffer创建一个屏障
        SequenceBarrier barrier = ringBuffer.newBarrier();

        //创建多个消费者组
        Consumer[] consumers = new Consumer[16];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer("C" + i);
        }

        //构建多消费者工作池
        WorkerPool<Order> workerPool = new WorkerPool<>(ringBuffer,
                barrier,
                new EventExceptionHandler(),
                consumers);

        //设置多个消费者的sequence序号，用于单独统计消费进度，并设置到ringBuffer中
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());

        //创建固定大小线程池
        ExecutorService pool = Executors.newFixedThreadPool(8);
        //启动workPool
        workerPool.start(pool);

        //倒计时器
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            final Producer producer = new Producer(ringBuffer);
            new Thread(() -> {
                try {
                    countDownLatch.await(); //100g个线程同时等待
                } catch (Exception e) {}
                for (int j = 0; j < 10; j++) {
                    producer.setData(UUID.randomUUID().toString());
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(2);
        System.out.println("线程创建完毕，开始生产数据-----------------");
        countDownLatch.countDown(); //同时触发100个线程同时开始

        TimeUnit.SECONDS.sleep(5);
        System.out.println("任务总是: " + consumers[0].getCount());
        pool.shutdown();
    }

    static class EventExceptionHandler implements ExceptionHandler<Order> {

        @Override
        public void handleEventException(Throwable throwable, long l, Order order) {

        }

        @Override
        public void handleOnStartException(Throwable throwable) {

        }

        @Override
        public void handleOnShutdownException(Throwable throwable) {

        }
    }
}
