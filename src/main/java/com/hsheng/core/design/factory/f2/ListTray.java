package com.hsheng.core.design.factory.f2;

import java.util.Iterator;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 8:41
 * @since TODO
 */
public class ListTray extends AbstTray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    protected String makeHtml() {
        StringBuilder builder = new StringBuilder();
        builder.append("<li>\n");
        builder.append(caption + "\n");
        builder.append("<ul>\n");

        Iterator<AbstItem> it = items.iterator();
        while (it.hasNext()) {
            AbstItem item = it.next();
            builder.append(item.makeHtml());
        }

        builder.append("</ul>\n");
        builder.append("</li>\n");
        return builder.toString();
    }
}
