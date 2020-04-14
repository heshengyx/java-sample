package com.hsheng.core.design.bridge;

/**
 * @description 桥接模式
 * @author hesheng
 * @date 2020/4/14 8:11
 * @since TODO
 */
public abstract class AbstDisplay {

    abstract void rawOpen();

    abstract void rawPrint();

    abstract void rawClose();
}
