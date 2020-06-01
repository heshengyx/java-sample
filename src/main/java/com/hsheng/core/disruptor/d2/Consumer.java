package com.hsheng.core.disruptor.d2;

import com.lmax.disruptor.WorkHandler;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/30 20:13
 * @since TODO
 */
public class Consumer implements WorkHandler<Order> {

    private String consumerId;

    private static AtomicInteger count = new AtomicInteger(0);

    private Random random = new Random();

    public Consumer(String consumerId) {
        this.consumerId = consumerId;
    }

    @Override
    public void onEvent(Order order) throws Exception {
        count.incrementAndGet();
        System.out.println("当前消费者：" + this.consumerId + ", 消费order id:" + order.getId());
    }

    public int getCount() {
        return count.get();
    }
}
