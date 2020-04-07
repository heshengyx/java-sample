package com.hsheng.core.design.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description 建造者模式-html编写文档
 * @author hesheng
 * @date 2020/4/7 8:27
 * @since TODO
 */
public class HtmlBuilder extends Builder {

    private String filename;
    private PrintWriter writer;

    @Override
    void makeTitle(String title) {
        filename = title + ".html";
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" + title + "</h1>");
    }

    @Override
    void makeString(String str) {
        writer.println("<p>" + str + "</p>");
    }

    @Override
    void makeItems(String[] items) {
        writer.println("<ul>");
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</ul>");
    }

    @Override
    void close() {
        writer.println("</body></html>");
        writer.close();
    }

    public String getResult() {
        return filename;
    }
}
