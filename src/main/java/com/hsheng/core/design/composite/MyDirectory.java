package com.hsheng.core.design.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description composite模式
 * @author hesheng
 * @date 2020/4/16 8:25
 * @since TODO
 */
public class MyDirectory extends Entry {

    private String name;
    private List<Entry> directory = new ArrayList<>();

    public MyDirectory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            size += entry.getSize(); //递归调用
        }
        return size;
    }

    /**
     * 重写父类add方法
     * @param entry
     * @return
     */
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.printList(prefix + "/" + name); //递归调用
        }
    }
}
