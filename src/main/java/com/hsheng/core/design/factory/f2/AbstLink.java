package com.hsheng.core.design.factory.f2;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 8:16
 * @since TODO
 */
public abstract class AbstLink extends AbstItem {

    protected String url;

    public AbstLink(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
