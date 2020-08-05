package com.hsheng.core.thread.sync.s1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/7/27 9:56
 * @since TODO
 */
public class AtomicSerialNumbers extends SerialNumbers {

    private AtomicInteger serialNumber = new AtomicInteger();

    public synchronized int nextSerialNumber() {
        return serialNumber.getAndIncrement();
    }
}
