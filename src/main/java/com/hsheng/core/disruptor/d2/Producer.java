package com.hsheng.core.disruptor.d2;

import com.lmax.disruptor.RingBuffer;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/30 20:24
 * @since TODO
 */
public class Producer {

    private final RingBuffer<Order> ringBuffer;

    public Producer(RingBuffer<Order> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void setData(String id) {
        long sequence = ringBuffer.next();
        try {
            Order order = ringBuffer.get(sequence);
            order.setId(id);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}
