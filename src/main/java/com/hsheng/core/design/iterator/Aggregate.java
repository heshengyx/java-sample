package com.hsheng.core.design.iterator;

/**
 * @description 迭代器模式-表示集合的接口
 * @author hesheng
 * @date 2020/1/7 14:39
 * @since TODO
 */
public interface Aggregate {

    /**
     * 遍历迭代器
     * @return
     */
    Iterator iterator();
}
