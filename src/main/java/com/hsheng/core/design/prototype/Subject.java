package com.hsheng.core.design.prototype;

/**
 * @description 原型模式-对象克隆
 * @author hesheng
 * @date 2020/3/1 19:01
 * @since TODO
 */
public class Subject implements Cloneable {

    private String name;

    public Subject(String name) {
        this.name = name;
    }

    /**
     * 对象克隆-浅复制
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Subject[" + name + "]";
    }
}
