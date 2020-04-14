package com.hsheng.core.design.factory.f2;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 抽象工厂模式
 * @author hesheng
 * @date 2020/4/13 8:20
 * @since TODO
 */
public abstract class AbstPage {

    protected String title;
    protected String author;
    protected List<AbstItem> content = new ArrayList<>();

    public AbstPage(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void add(AbstItem item) {
        content.add(item);
    }

    public void output() {
        String filename = title + ".html";
        /*try (Writer writer = new FileWriter(filename)) {
            writer.write(this.makeHtml());
            System.out.println(filename + "编写完成");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        System.out.println(this.makeHtml());
        System.out.println(filename + "编写完成");
    }

    protected abstract String makeHtml();
}
