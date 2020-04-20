package com.hsheng.core.design.decorator;

/**
 * @description 装饰器模式
 * @author hesheng
 * @date 2020/4/17 8:28
 * @since TODO
 */
public abstract class Border extends Display {

    protected Display display; //表示被装饰物

    protected Border(Display display) {
        this.display = display;
    }
}
