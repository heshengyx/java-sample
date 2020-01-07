package com.hsheng.core.design.template;

/**
 * @description TODO
 * @author hesheng
 * @date 2020/1/7 18:25
 * @since TODO
 */
public class CharDisplay extends AbstractDisplay {

    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    void open() {
        System.out.print("<<");
    }

    @Override
    void print() {
        System.out.print(ch);
    }

    @Override
    void close() {
        System.out.println(">>");
    }
}
