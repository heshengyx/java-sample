package com.hsheng.core.disruptor.d1;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @description 生产者
 * @author hesheng
 * @date 2020/5/30 17:47
 * @since TODO
 */
public class LongEventProducer {

    /**
     * 环形数组
     */
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * 生产事件 往环形数组放数据
     * @param buffer
     */
    public void onData(ByteBuffer buffer) {
        long sequence = ringBuffer.next();  // Grab the next sequence
        try {
            LongEvent event = ringBuffer.get(sequence); // Get the entry in the Disruptor
            // for the sequence
            event.set(buffer.getLong(0));  // Fill with data
        } finally {
            //发布事件
            ringBuffer.publish(sequence);
        }
    }
}
