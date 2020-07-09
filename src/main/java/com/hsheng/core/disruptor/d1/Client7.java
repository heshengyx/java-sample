package com.hsheng.core.disruptor.d1;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

/**
 * 1、声明Event来包含需要传递的数据
 * 2、使用EventFactory来实例化Event对象
 * 3、声明消费者事件处理器
 * 4、生产者发送事件
 * @description TODO
 * @author hesheng
 * @date 2020/5/30 17:49
 * @since TODO
 */
public class Client7 {

    public static void main(String[] args) throws Exception {
        //ExecutorService executor = Executors.newCachedThreadPool();
        // The factory for the event
        LongEventFactory factory = new LongEventFactory();

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;

        // Construct the Disruptor with a MultipleProducerSequencer
        //Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, DaemonThreadFactory.INSTANCE);
        // Construct the Disruptor with a SingleProducerSequencer
        Disruptor<LongEvent> disruptor = new Disruptor(
                factory, bufferSize, DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new BlockingWaitStrategy());

        /**
         * 使用handleEventsWithWorkerPool就可以完成不重复消费，
         * 使用handleEventsWith就是重复消费
         */
        // Connect the handler
        // 可以同时发给多个消费者
        disruptor.handleEventsWith(new LongEventHandler(), new LongEventHandler());
        //disruptor.handleEventsWith(new LongEventHandler());

        // Start the Disruptor, starts all threads running
        disruptor.start();

        //以上创建消费者，并启动
        //以下创建生产者

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        //创建生产者
        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer buffer = ByteBuffer.allocate(8);
        for (long i = 0; i < 100; i++) {
            buffer.putLong(0, i);
            producer.onData(buffer);
            //Thread.sleep(1000);
        }
        disruptor.shutdown();
    }
}
