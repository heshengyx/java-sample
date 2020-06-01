package com.hsheng.core.disruptor.d1;

import com.lmax.disruptor.EventHandler;

/**
 * @description 消费者, 定义事件的具体消费实现
 * @author hesheng
 * @date 2020/5/30 17:43
 * @since TODO
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
        System.out.println("Event: " + event + "," + event.getValue() + "," + Thread.currentThread().getName());
    }
}
