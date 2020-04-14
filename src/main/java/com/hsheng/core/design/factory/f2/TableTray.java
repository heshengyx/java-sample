package com.hsheng.core.design.factory.f2;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 9:09
 * @since TODO
 */
public class TableTray extends AbstTray {

    public TableTray(String caption) {
        super(caption);
    }

    @Override
    protected String makeHtml() {
        return null;
    }
}
