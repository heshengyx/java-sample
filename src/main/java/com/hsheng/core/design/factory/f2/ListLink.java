package com.hsheng.core.design.factory.f2;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 8:38
 * @since TODO
 */
public class ListLink extends AbstLink {

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    protected String makeHtml() {
        return " <li><a href\"" + url + "\">" + caption + "</a></li>\n";
    }
}
