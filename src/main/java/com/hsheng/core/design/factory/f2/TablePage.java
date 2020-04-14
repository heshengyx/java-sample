package com.hsheng.core.design.factory.f2;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 9:10
 * @since TODO
 */
public class TablePage extends AbstPage {

    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    protected String makeHtml() {
        return null;
    }
}
