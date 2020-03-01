package com.hsheng.core.design.iterator;

/**
 * @description 迭代器模式-遍历集合的接口
 * @author hesheng
 * @date 2020/1/7 15:01
 * @since TODO
 */
public interface Iterator {

    /**
     * 判断是否存在下一个元素
     * @return
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     * @return
     */
    Object next();
}
