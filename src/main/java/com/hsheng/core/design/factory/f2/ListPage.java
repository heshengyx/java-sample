package com.hsheng.core.design.factory.f2;

import java.util.Iterator;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 8:55
 * @since TODO
 */
public class ListPage extends AbstPage {

    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    protected String makeHtml() {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head><title>" + title + "</title></head>\n");
        builder.append("<body>\n");
        builder.append("<h1>" + title + "</h1>\n");
        builder.append("<ul>\n");

        Iterator<AbstItem> it = content.iterator();
        while (it.hasNext()) {
            AbstItem item = it.next();
            builder.append(item.makeHtml());
        }

        builder.append("</ul>\n");
        builder.append("<hr><address>" + author + "</address>");
        builder.append("</body></html>\n");
        return builder.toString();
    }
}
