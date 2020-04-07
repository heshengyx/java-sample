package com.hsheng.core.design.builder;

/**
 * @description 建造者模式-纯文本编写文档
 * @author hesheng
 * @date 2020/4/7 8:22
 * @since TODO
 */
public class TextBuilder extends Builder {

    private StringBuilder builder = new StringBuilder();

    @Override
    void makeTitle(String title) {
        builder.append("===========================================\n");
        builder.append("[" + title + "]\n");
        builder.append("\n");
    }

    @Override
    void makeString(String str) {
        builder.append(str + "\n");
        builder.append("\n");
    }

    @Override
    void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            builder.append("item: " + items[i] + "\n");
        }
        builder.append("\n");
    }

    @Override
    void close() {
        builder.append("===========================================\n");
    }

    public String getResult() {
        return builder.toString();
    }
}
