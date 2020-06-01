package com.hsheng.core.disruptor.d1;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/5/30 17:42
 * @since TODO
 */
public class LongEvent {

    private long value;

    public void set(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
