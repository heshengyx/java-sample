package com.hsheng.core.design.builder;

/**
 * @description 建造者模式
 * @author hesheng
 * @date 2020/4/7 8:11
 * @since TODO
 */
public abstract class Builder {

    /**
     * 编写标题
     * @param title
     */
    abstract void makeTitle(String title);

    /**
     * 编写字符串
     * @param str
     */
    abstract void makeString(String str);

    /**
     * 编写条目
     * @param items
     */
    abstract void makeItems(String[] items);

    /**
     * 完成编写
     */
    abstract void close();
}
