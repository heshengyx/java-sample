package com.hsheng.core.thread.sync.s1;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/7/27 9:51
 * @since TODO
 */
public class SynchronizedSerialNumbers extends SerialNumbers {

    private int serialNumber = 0;

    public synchronized int nextSerialNumber() {
        return serialNumber++;
    }
}
