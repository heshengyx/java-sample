package com.hsheng.core.disruptor.d1;

import com.lmax.disruptor.EventFactory;

/**
 * @description 事件工厂
 * @author hesheng
 * @date 2020/5/30 17:42
 * @since TODO
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
