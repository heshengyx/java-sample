package com.hsheng.core.design.composite;

/**
 * @description composite模式
 * @author hesheng
 * @date 2020/4/16 8:22
 * @since TODO
 */
public class MyFile extends Entry {

    private String name;
    private int size;

    public MyFile(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
