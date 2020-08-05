package com.hsheng.core.thread.sync.s1;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/7/27 9:43
 * @since TODO
 */
public class SerialNumbers {

    private volatile int serialNumber = 0;

    public int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }
}
