package com.hsheng.core.design.factory.f2;

/**
 * @description 抽象工厂模式-具体工厂
 * @author hesheng
 * @date 2020/4/13 8:56
 * @since TODO
 */
public class ListFactory extends AbstFactory {

    @Override
    protected AbstLink createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    protected AbstTray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    protected AbstPage createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
