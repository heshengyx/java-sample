package com.hsheng.core.design.factory.f2;

/**
 * @description 抽象工厂模式-具体工厂
 * @author hesheng
 * @date 2020/4/13 9:06
 * @since TODO
 */
public class TableFactory extends AbstFactory {

    @Override
    protected AbstLink createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    protected AbstTray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    protected AbstPage createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
