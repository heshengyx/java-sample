package com.hsheng.core.design.prototype;

/**
 * @description 原型模式
 * @author hesheng
 * @date 2020/4/8 8:09
 * @since TODO
 */
public interface Product extends Cloneable {

    void use(String s);

    Product createClone();
}
