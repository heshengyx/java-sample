package com.hsheng.core.design.template;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/7 18:27
 * @since TODO
 */
public class StringDisplay extends AbstractDisplay {

    private String name;
    private int width;

    public StringDisplay(String name) {
        this.name = name;
        this.width = name.getBytes().length;
    }

    @Override
    void open() {
        printLine();
    }

    @Override
    void print() {
        System.out.println("|" + name + "|");
    }

    @Override
    void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
