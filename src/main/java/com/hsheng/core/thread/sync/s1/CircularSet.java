package com.hsheng.core.thread.sync.s1;

import java.util.Arrays;

/**
 * @description 数据结构-环形SET
 * @author hesheng
 * @date 2020/7/27 9:39
 * @since TODO
 */
public class CircularSet {

    private int[] array;
    private int size;
    private int index = 0;

    public CircularSet(int size) {
        this.size = size;
        array = new int[size];
        // Initialize to a value not produced
        // by SerialNumbers:
        Arrays.fill(array, -1);
    }

    public synchronized void add(int i) {
        array[index] = i;
        // Wrap index and write over old elements:
        index = ++index % size;
    }

    public synchronized boolean contains(int val) {
        for(int i = 0; i < size; i++)
            if(array[i] == val) return true;
        return false;
    }
}
