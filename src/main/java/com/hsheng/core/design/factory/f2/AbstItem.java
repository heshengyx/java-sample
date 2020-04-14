package com.hsheng.core.design.factory.f2;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 8:14
 * @since TODO
 */
public abstract class AbstItem {

    protected String caption;

    public AbstItem(String caption) {
        this.caption = caption;
    }

    protected abstract String makeHtml();
}
