package com.hsheng.core.design.factory.f2;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 9:07
 * @since TODO
 */
public class TableLink extends AbstLink {

    public TableLink(String caption, String url) {
       super(caption, url);
    }

    @Override
    protected String makeHtml() {
        return "<td><a href\"" + url + "\">" + caption + "</a></td>\n";
    }
}
